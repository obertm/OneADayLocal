import java.util.ArrayList;

public final class EulerTests {
    private static int passed = 0;
    private static int failed = 0;
    private static int skipped = 0;

    private static void assertEquals(String name, long expected, long actual) {
        if (expected == actual) {
            passed++;
        } else {
            failed++;
            System.out.printf("FAIL: %s expected=%d actual=%d%n", name, expected, actual);
        }
    }

    private static void test001() {
        assertEquals("Euler001: sumMultiples3or5Below(10)", 23, Euler001.sumMultiples3or5Below(10));
        assertEquals("Euler001: sumMultiples3or5Below(1000)", 233168, Euler001.sumMultiples3or5Below(1000));
    }

    private static void test002() {
        assertEquals("Euler002: sumEvenFib(10)", 10, Euler002.sumEvenFib(10));
        assertEquals("Euler002: sumEvenFib(100)", 44, Euler002.sumEvenFib(100));
        assertEquals("Euler002: sumEvenFib(4_000_000)", 4613732, Euler002.sumEvenFib(4_000_000));
    }

    private static void test003() {
        assertEquals("Euler003: largestPrimeFactor(13195)", 29, Euler003.largestPrimeFactor(13195));
        assertEquals("Euler003: largestPrimeFactor(600851475143)", 6857, Euler003.largestPrimeFactor(600851475143L));
    }

    private static void test004() {
        assertEquals("Euler004: largestPalindromeProductNDigits(2)", 9009, Euler004.largestPalindromeProductNDigits(2));
        assertEquals("Euler004: largestPalindromeProductNDigits(3)", 906609, Euler004.largestPalindromeProductNDigits(3));
    }

    private static void test005() {
        assertEquals("Euler005: lcmUpTo(10)", 2520, Euler005.lcmUpTo(10));
        assertEquals("Euler005: lcmUpTo(20)", 232792560, Euler005.lcmUpTo(20));
    }

    private static void test006() {
        assertEquals("Euler006: difference(10)", 2640, Euler006.difference(10));
        assertEquals("Euler006: difference(100)", 25164150, Euler006.difference(100));
    }

    private static void test007() {
        assertEquals("Euler007: nthPrime(6)", 13, Euler007.nthPrime(6));
        assertEquals("Euler007: nthPrime(10001)", 104743, Euler007.nthPrime(10001));
    }

    private static void test008() {
        String digits =
            "73167176531330624919225119674426574742355349194934" +
            "96983520312774506326239578318016984801869478851843" +
            "85861560789112949495459501737958331952853208805511" +
            "12540698747158523863050715693290963295227443043557" +
            "66896648950445244523161731856403098711121722383113" +
            "62229893423380308135336276614282806444486645238749" +
            "30358907296290491560440772390713810515859307960866" +
            "70172427121883998797908792274921901699720888093776" +
            "65727333001053367881220235421809751254540594752243" +
            "52584907711670556013604839586446706324415722155397" +
            "53697817977846174064955149290862569321978468622482" +
            "83972241375657056057490261407972968652414535100474" +
            "82166370484403199890008895243450658541227588666881" +
            "16427171479924442928230863465674813919123162824586" +
            "17866458359124566529476545682848912883142607690042" +
            "24219022671055626321111109370544217506941658960408" +
            "07198403850962455444362981230987879927244284909188" +
            "84580156166097919133875499200524063689912560717606" +
            "05886116467109405077541002256983155200055935729725" +
            "71636269561882670428252483600823257530420752963450";
        assertEquals("Euler008: maxAdjacentProduct(window=4)", 5832, Euler008.maxAdjacentProduct(digits, 4));
        assertEquals("Euler008: maxAdjacentProduct(window=13)", 23514624000L, Euler008.maxAdjacentProduct(digits, 13));
    }

    private static void test009() {
        assertEquals("Euler009: tripletProductForSum(12)", 60, Euler009.tripletProductForSum(12));
        assertEquals("Euler009: tripletProductForSum(1000)", 31875000, Euler009.tripletProductForSum(1000));
    }

    // --- Generic future-proof tests ---
    private static final java.util.Map<Integer, String> EXPECTED_DEFAULT = new java.util.HashMap<>();
    static {
        // Known default answers (no args) for early problems; extend as you implement more.
        EXPECTED_DEFAULT.put(1, "233168");
        EXPECTED_DEFAULT.put(2, "4613732");
        EXPECTED_DEFAULT.put(3, "6857");
        EXPECTED_DEFAULT.put(4, "906609");
        EXPECTED_DEFAULT.put(5, "232792560");
        EXPECTED_DEFAULT.put(6, "25164150");
        EXPECTED_DEFAULT.put(7, "104743");
        EXPECTED_DEFAULT.put(8, "23514624000");
        EXPECTED_DEFAULT.put(9, "31875000");
        EXPECTED_DEFAULT.put(10, "142913828922");
        EXPECTED_DEFAULT.put(11, "70600674");
        EXPECTED_DEFAULT.put(12, "76576500");
        EXPECTED_DEFAULT.put(13, "5537376230");
        EXPECTED_DEFAULT.put(14, "837799");
        EXPECTED_DEFAULT.put(15, "137846528820");
        EXPECTED_DEFAULT.put(16, "1366");
        EXPECTED_DEFAULT.put(17, "21124");
        EXPECTED_DEFAULT.put(18, "1074");
        EXPECTED_DEFAULT.put(19, "171");
        EXPECTED_DEFAULT.put(20, "648");
    EXPECTED_DEFAULT.put(21, "31626");
    EXPECTED_DEFAULT.put(22, "871198282");
    EXPECTED_DEFAULT.put(23, "4179871");
    EXPECTED_DEFAULT.put(24, "2783915460");
    EXPECTED_DEFAULT.put(25, "4782");
    EXPECTED_DEFAULT.put(26, "983");
    EXPECTED_DEFAULT.put(27, "-59231");
    EXPECTED_DEFAULT.put(28, "669171001");
    EXPECTED_DEFAULT.put(29, "9183");
    EXPECTED_DEFAULT.put(30, "443839");
    EXPECTED_DEFAULT.put(31, "73682");
    EXPECTED_DEFAULT.put(32, "45228");
    EXPECTED_DEFAULT.put(33, "100");
    EXPECTED_DEFAULT.put(34, "40730");
    EXPECTED_DEFAULT.put(35, "55");
    EXPECTED_DEFAULT.put(36, "872187");
    EXPECTED_DEFAULT.put(37, "748317");
    EXPECTED_DEFAULT.put(38, "932718654");
    EXPECTED_DEFAULT.put(39, "840");
    EXPECTED_DEFAULT.put(40, "210");
    EXPECTED_DEFAULT.put(41, "7652413");
    // 42 requires external data file; skip
    // EXPECTED_DEFAULT.put(43, "16695334890"); // heavy generation; optional
    EXPECTED_DEFAULT.put(44, "5482660");
    EXPECTED_DEFAULT.put(45, "1533776805");
    EXPECTED_DEFAULT.put(46, "5777");
    EXPECTED_DEFAULT.put(47, "134043");
    EXPECTED_DEFAULT.put(48, "9110846700");
    EXPECTED_DEFAULT.put(49, "296962999629");
    EXPECTED_DEFAULT.put(50, "997651");
    }

    private static boolean classExists(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static boolean isTodoSource(String className) {
        java.nio.file.Path p = java.nio.file.Path.of(className + ".java");
        if (!java.nio.file.Files.exists(p)) return false;
        try {
            String src = java.nio.file.Files.readString(p);
            return src.contains("TODO");
        } catch (Exception e) {
            return false;
        }
    }

    private static String runMainCapture(String className, String... args) throws Exception {
        java.io.PrintStream oldOut = System.out;
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream ps = new java.io.PrintStream(baos);
        System.setOut(ps);
        try {
            Class<?> cls = Class.forName(className);
            java.lang.reflect.Method main = cls.getMethod("main", String[].class);
            main.invoke(null, (Object) args);
        } finally {
            System.setOut(oldOut);
        }
        return baos.toString().trim();
    }

    private static void testExpectedDefaultsRange(int from, int to) {
        for (int n = from; n <= to; n++) {
            String className = String.format("Euler%03d", n);
            if (!classExists(className)) continue; // not present yet
            if (isTodoSource(className)) {
                skipped++;
                continue;
            }
            String expected = EXPECTED_DEFAULT.get(n);
            if (expected == null) {
                // no expectation defined yet
                skipped++;
                continue;
            }
            try {
                String actual = runMainCapture(className);
                if (expected.equals(actual)) {
                    passed++;
                } else {
                    failed++;
                    System.out.printf("FAIL: %s default expected=%s actual=%s%n", className, expected, actual);
                }
            } catch (Exception e) {
                failed++;
                System.out.printf("FAIL: %s default threw %s%n", className, e);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Runnable> tests = new ArrayList<>();
        tests.add(EulerTests::test001);
        tests.add(EulerTests::test002);
        tests.add(EulerTests::test003);
        tests.add(EulerTests::test004);
        tests.add(EulerTests::test005);
        tests.add(EulerTests::test006);
        tests.add(EulerTests::test007);
        tests.add(EulerTests::test008);
        tests.add(EulerTests::test009);

        long t0 = System.nanoTime();
        tests.forEach(Runnable::run);
        long t1 = System.nanoTime();

    // Generic default-output checks for 001..050
    testExpectedDefaultsRange(1, 50);

    System.out.printf("\nTests: %d passed, %d failed, %d skipped (%.3f ms)\n", passed, failed, skipped, (t1 - t0) / 1_000_000.0);
        if (failed > 0) System.exit(1);
    }
}
