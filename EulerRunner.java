import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.*;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;

public final class EulerRunner {
    private static final Pattern EULER_PATTERN = Pattern.compile("Euler(\\d{3})\\.(java|class)");

    private static class ProblemInfo {
        final int number;
        final String className;
        final boolean hasSource;
        final boolean hasClass;
        final boolean isTodo;
        ProblemInfo(int number, boolean hasSource, boolean hasClass, boolean isTodo) {
            this.number = number;
            this.className = String.format("Euler%03d", number);
            this.hasSource = hasSource;
            this.hasClass = hasClass;
            this.isTodo = isTodo;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            // Interactive mode
            interactive();
            return;
        }
    switch (args[0]) {
            case "list":
        listCmd();
                break;
            case "run":
        runCmd(Arrays.copyOfRange(args, 1, args.length));
                break;
            case "all":
        boolean includeTodo = args.length > 1 && "--include-todo".equals(args[1]);
        runAllCmd(includeTodo);
                break;
            case "bench":
                benchCmd(Arrays.copyOfRange(args, 1, args.length));
                break;
            case "help":
            case "-h":
            case "--help":
            default:
                printHelp();
        }
    }

    private static void printHelp() {
    System.out.println("Usage: java EulerRunner [command] [args]\n" +
                "Commands:\n" +
                "  list                List discovered Euler problems.\n" +
        "  run <N> [args...]    Run Euler problem N with optional args.\n" +
        "  all [--include-todo] Run all discovered Euler problems (skip TODOs by default).\n" +
                "  bench [--update-readme]  Profile all problems and print a Markdown table; with --update-readme, also write into README.md.\n" +
                "  help                Show this help.\n" +
                "If no command is provided, interactive mode starts.");
    }

    private static void interactive() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println();
                System.out.println("== Project Euler Runner ==");
        System.out.println("1) List problems");
                System.out.println("2) Run a problem");
        System.out.println("3) Run all (skip TODOs)");
        System.out.println("4) Bench all (print table)");
                System.out.println("q) Quit");
                System.out.print("> ");
                String line = sc.nextLine().trim();
                if (line.equalsIgnoreCase("q")) return;
                switch (line) {
                    case "1":
                        listCmd();
                        break;
                    case "2":
                        System.out.print("Enter problem number (e.g., 1, 2, 3): ");
                        String nStr = sc.nextLine().trim();
                        if (!nStr.isEmpty()) {
                            runNumber(nStr, new String[0]);
                        }
                        break;
                    case "3":
            runAllCmd(false);
                        break;
                    case "4":
                        benchCmd(new String[0]);
                        break;
                    default:
                        System.out.println("Unknown option.");
                }
            }
        }
    }

    private static class BenchResult {
        final int number;
        final String output;
        final double millis;
        BenchResult(int number, String output, double millis) {
            this.number = number; this.output = output; this.millis = millis;
        }
    }

    private static List<ProblemInfo> discoverProblems() {
        Map<Integer, ProblemInfo> map = new TreeMap<>();
        File dir = new File(".");
        File[] files = dir.listFiles();
        if (files == null) return new ArrayList<>();
        for (File f : files) {
            Matcher m = EULER_PATTERN.matcher(f.getName());
            if (m.matches()) {
                int n = Integer.parseInt(m.group(1));
                boolean isJava = f.getName().endsWith(".java");
                boolean isClass = f.getName().endsWith(".class");
                ProblemInfo prev = map.get(n);
                boolean hasSource = isJava || (prev != null && prev.hasSource);
                boolean hasClass = isClass || (prev != null && prev.hasClass);
                boolean isTodo = false;
                if (isJava) {
                    try {
                        String src = Files.readString(Path.of(f.getName()));
                        isTodo = src.contains("TODO");
                    } catch (Exception ignore) {}
                } else if (prev != null) {
                    isTodo = prev.isTodo;
                }
                map.put(n, new ProblemInfo(n, hasSource, hasClass, isTodo));
            }
        }
        return new ArrayList<>(map.values());
    }

    private static void listCmd() {
        List<ProblemInfo> problems = discoverProblems();
        if (problems.isEmpty()) {
            System.out.println("No Euler problems found in current directory.");
            return;
        }
    System.out.println("Discovered problems:");
    for (ProblemInfo p : problems) {
        String status = p.isTodo ? "todo" : "ok";
        System.out.printf("- %03d: %s [source:%s, class:%s, status:%s]%n",
            p.number, p.className,
            p.hasSource ? "yes" : "no",
            p.hasClass ? "yes" : "no",
            status);
    }
    }

    private static void runCmd(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java EulerRunner run <N> [args...]");
            return;
        }
        String nStr = args[0];
        String[] passArgs = Arrays.copyOfRange(args, 1, args.length);
        runNumber(nStr, passArgs);
    }

    private static void runNumber(String nStr, String[] passArgs) {
        int n;
        try {
            n = Integer.parseInt(nStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid problem number: " + nStr);
            return;
        }
        String className = String.format("Euler%03d", n);
        if (isTodoSource(className)) {
            System.out.println("Warning: " + className + " appears to be TODO.");
        }
        if (!ensureClassAvailable(className)) {
            System.out.println("Problem class not found and could not compile: " + className);
            return;
        }
        try {
            Class<?> cls = Class.forName(className);
            Method main = cls.getMethod("main", String[].class);
            System.out.printf("== Running %s ==%n", className);
            long t0 = System.nanoTime();
            main.invoke(null, (Object) passArgs);
            long t1 = System.nanoTime();
            System.out.printf("[done in %.3f ms]%n", (t1 - t0) / 1_000_000.0);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        } catch (NoSuchMethodException e) {
            System.out.println("No main(String[]) in: " + className);
        } catch (Exception e) {
            System.out.println("Error running " + className + ": " + e.getCause());
        }
    }

    private static void runAllCmd(boolean includeTodo) {
        List<ProblemInfo> problems = discoverProblems();
        if (problems.isEmpty()) {
            System.out.println("No Euler problems found in current directory.");
            return;
        }
        for (ProblemInfo p : problems) {
            if (!includeTodo && p.isTodo) continue;
            runNumber(Integer.toString(p.number), new String[0]);
        }
    }

    private static BenchResult runAndCapture(int n) {
        String className = String.format("Euler%03d", n);
    if (!ensureClassAvailable(className)) return new BenchResult(n, "<compile error>", Double.NaN);
        java.io.PrintStream oldOut = System.out;
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream ps = new java.io.PrintStream(baos);
        try {
            System.setOut(ps);
            Class<?> cls = Class.forName(className);
            Method main = cls.getMethod("main", String[].class);
            long t0 = System.nanoTime();
            main.invoke(null, (Object) new String[0]);
            long t1 = System.nanoTime();
            double ms = (t1 - t0) / 1_000_000.0;
            ps.flush();
            String out = baos.toString().trim();
            return new BenchResult(n, out, ms);
        } catch (Throwable t) {
            return new BenchResult(n, "<error>", Double.NaN);
        } finally {
            System.setOut(oldOut);
        }
    }

    private static void benchCmd(String[] args) {
        // Options: --update-readme, --range A-B, --only n1,n2,...
        boolean updateReadme = false;
        int rangeStart = -1, rangeEnd = -1;
        Set<Integer> only = new TreeSet<>();
        for (String a : args) {
            if ("--update-readme".equals(a)) { updateReadme = true; }
            else if (a.startsWith("--range")) {
                String[] parts = a.split("=", 2);
                if (parts.length == 2) {
                    String[] ab = parts[1].split("-", 2);
                    try {
                        rangeStart = Integer.parseInt(ab[0]);
                        rangeEnd = Integer.parseInt(ab[1]);
                    } catch (Exception ignore) {}
                }
            } else if (a.startsWith("--only")) {
                String[] parts = a.split("=", 2);
                if (parts.length == 2) {
                    for (String s : parts[1].split(",")) {
                        try { only.add(Integer.parseInt(s)); } catch (Exception ignore) {}
                    }
                }
            }
        }

        List<ProblemInfo> problems = discoverProblems();
        List<BenchResult> results = new ArrayList<>();
        for (ProblemInfo p : problems) {
            if (p.isTodo) continue;
            if (rangeStart != -1 && rangeEnd != -1) {
                if (p.number < rangeStart || p.number > rangeEnd) continue;
            }
            if (!only.isEmpty() && !only.contains(p.number)) continue;
            results.add(runAndCapture(p.number));
        }
        results.sort(Comparator.comparingInt(r -> r.number));
        String table = buildMarkdownTable(results);
        System.out.println(table);
        if (updateReadme) {
            if (rangeStart != -1 || !only.isEmpty()) {
                updateReadmeMerged(results);
            } else {
                updateReadme(table);
            }
        }
    }

    private static String buildMarkdownTable(List<BenchResult> results) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!-- BEGIN: EULER_RESULTS -->\n");
        sb.append("## Results\n\n");
        sb.append("| # | Answer | Time (ms) |\n");
        sb.append("|---:|:------|---------:|\n");
        for (BenchResult r : results) {
            String ans = r.output.replace("|", "\\|");
            String ms = Double.isNaN(r.millis) ? "-" : String.format(java.util.Locale.ROOT, "%.3f", r.millis);
            sb.append(String.format(java.util.Locale.ROOT, "| %03d | %s | %s |\n", r.number, ans, ms));
        }
        sb.append("<!-- END: EULER_RESULTS -->\n");
        return sb.toString();
    }

    private static void updateReadme(String tableBlock) {
        Path readme = Path.of("README.md");
        String begin = "<!-- BEGIN: EULER_RESULTS -->";
        String end = "<!-- END: EULER_RESULTS -->";
        try {
            String content = Files.exists(readme) ? Files.readString(readme) : "";
            int i = content.indexOf(begin);
            int j = content.indexOf(end);
            if (i >= 0 && j > i) {
                String before = content.substring(0, i);
                String after = content.substring(j + end.length()).trim();
                String joined = before + tableBlock + "\n" + after + "\n";
                Files.writeString(readme, joined);
            } else {
                // Append to end
                String sep = content.isEmpty() ? "" : (content.endsWith("\n") ? "" : "\n\n");
                Files.writeString(readme, content + sep + tableBlock + "\n");
            }
            System.out.println("README.md updated with results table.");
        } catch (Exception e) {
            System.out.println("Failed to update README.md: " + e);
        }
    }

    private static void updateReadmeMerged(List<BenchResult> newResults) {
        Path readme = Path.of("README.md");
        String begin = "<!-- BEGIN: EULER_RESULTS -->";
        String end = "<!-- END: EULER_RESULTS -->";
        try {
            String content = Files.exists(readme) ? Files.readString(readme) : "";
            Map<Integer, String[]> existing = parseResultsBlock(content);
            for (BenchResult r : newResults) {
                String ans = r.output.replace("|", "\\|");
                String ms = Double.isNaN(r.millis) ? "-" : String.format(java.util.Locale.ROOT, "%.3f", r.millis);
                existing.put(r.number, new String[]{ans, ms});
            }
            // Build merged table sorted by problem number
            List<Integer> keys = new ArrayList<>(existing.keySet());
            Collections.sort(keys);
            StringBuilder sb = new StringBuilder();
            sb.append("<!-- BEGIN: EULER_RESULTS -->\n");
            sb.append("## Results\n\n");
            sb.append("| # | Answer | Time (ms) |\n");
            sb.append("|---:|:------|---------:|\n");
            for (int k : keys) {
                String[] v = existing.get(k);
                sb.append(String.format(java.util.Locale.ROOT, "| %03d | %s | %s |\n", k, v[0], v[1]));
            }
            sb.append("<!-- END: EULER_RESULTS -->\n");

            // Replace or append block
            int i = content.indexOf(begin);
            int j = content.indexOf(end);
            String newBlock = sb.toString();
            if (i >= 0 && j > i) {
                String before = content.substring(0, i);
                String after = content.substring(j + end.length()).trim();
                String joined = before + newBlock + "\n" + after + "\n";
                Files.writeString(readme, joined);
            } else {
                String sep = content.isEmpty() ? "" : (content.endsWith("\n") ? "" : "\n\n");
                Files.writeString(readme, content + sep + newBlock + "\n");
            }
            System.out.println("README.md incrementally updated with results.");
        } catch (Exception e) {
            System.out.println("Failed to incrementally update README.md: " + e);
        }
    }

    private static Map<Integer, String[]> parseResultsBlock(String content) {
        Map<Integer, String[]> map = new TreeMap<>();
        String begin = "<!-- BEGIN: EULER_RESULTS -->";
        String end = "<!-- END: EULER_RESULTS -->";
        int i = content.indexOf(begin);
        int j = content.indexOf(end);
        if (i >= 0 && j > i) {
            String block = content.substring(i, j);
            Scanner sc = new Scanner(block);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.startsWith("| ")) {
                    // Expect: | NNN | Answer | Time |
                    String[] parts = line.split("\\|", -1);
                    if (parts.length >= 4) {
                        try {
                            int num = Integer.parseInt(parts[1].trim());
                            String ans = parts[2].trim();
                            String ms = parts[3].trim();
                            map.put(num, new String[]{ans, ms});
                        } catch (Exception ignore) {}
                    }
                }
            }
            sc.close();
        }
        return map;
    }

    private static boolean ensureClassAvailable(String className) {
        try {
            Class.forName(className);
            return true; // already on classpath
        } catch (ClassNotFoundException ignore) { }
        // Try to compile source if available
        Path source = Path.of(className + ".java");
        if (!Files.exists(source)) return false;
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) return false;
        int code = compiler.run(null, null, null, source.toString());
        if (code != 0) return false;
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static boolean isTodoSource(String className) {
        Path source = Path.of(className + ".java");
        if (!Files.exists(source)) return false;
        try {
            String src = Files.readString(source);
            return src.contains("TODO");
        } catch (Exception e) {
            return false;
        }
    }
}
