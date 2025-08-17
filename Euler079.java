// Euler 079: Passcode derivation
// Given successful login attempts, derive the shortest possible secret passcode.
// https://projecteuler.net/problem=79
public final class Euler079 {
    public static void main(String[] args) {
        java.util.List<String> lines = loadLines();
        // Build graph of precedence constraints between digits '0'..'9'
        boolean[][] before = new boolean[10][10];
        boolean[] present = new boolean[10];
        for (String line : lines) {
            if (line.length() < 3) continue;
            int a = line.charAt(0) - '0';
            int b = line.charAt(1) - '0';
            int c = line.charAt(2) - '0';
            present[a] = present[b] = present[c] = true;
            before[a][b] = true; before[b][c] = true; before[a][c] = true;
        }
        // Kahn topological sort choosing smallest available digit first
        StringBuilder pass = new StringBuilder();
        boolean[] used = new boolean[10];
        int remaining = 0; for (int d = 0; d < 10; d++) if (present[d]) remaining++;
        while (remaining > 0) {
            int pick = -1;
            for (int d = 0; d < 10; d++) {
                if (!present[d] || used[d]) continue;
                boolean hasPred = false;
                for (int p = 0; p < 10; p++) if (!used[p] && before[p][d]) { hasPred = true; break; }
                if (!hasPred) { pick = d; break; }
            }
            if (pick == -1) { System.out.println("TODO"); return; } // cycle/unexpected
            used[pick] = true; remaining--; pass.append((char)('0' + pick));
        }
        System.out.println(pass.toString());
    }

    private static java.util.List<String> loadLines() {
        java.nio.file.Path p = java.nio.file.Path.of("Euler079.txt");
        try {
            if (java.nio.file.Files.exists(p)) {
                return java.nio.file.Files.readAllLines(p);
            }
        } catch (Exception ignore) {}
        // Fallback to the known Project Euler sample set
        String[] arr = {
            "319","680","180","690","129","620","762","689","762","318","368","710","720","629","168","160","689","716","731","736","729","316","729","729","710","769","290","719","680","318","389","162","289","162","718","729","319","790","680","890","362","319","760","316","729","380","319","728","716"
        };
        return java.util.Arrays.asList(arr);
    }
}
