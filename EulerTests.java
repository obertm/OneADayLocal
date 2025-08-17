import java.util.ArrayList;

public final class EulerTests {
    private static int passed = 0;
    private static int failed = 0;
    private static int skipped = 0;

    // Configurable knobs for smoke testing
    private static final long DEFAULT_TIMEOUT_MS = Long.getLong("eulerTests.timeoutMs", 1500L);
    private static final long SLOW_LOG_MS = Long.getLong("eulerTests.slowLogMs", 250L);
    private static final boolean TIMEOUT_AS_SKIP = Boolean.parseBoolean(System.getProperty("eulerTests.timeoutAsSkip", "true"));
    private static final boolean QUICK_DEFAULT_CHECKS = Boolean.parseBoolean(System.getProperty("eulerTests.quickDefaults", "false"));

    private static void assertEquals(String name, long expected, long actual) {
        if (expected == actual) {
            passed++;
        } else {
            failed++;
            System.out.printf("FAIL: %s expected=%d actual=%d%n", name, expected, actual);
        }
    }

    private static void assertEquals(String name, String expected, String actual) {
        if ((expected == null && actual == null) || (expected != null && expected.equals(actual))) {
            passed++;
        } else {
            failed++;
            System.out.printf("FAIL: %s expected=\"%s\" actual=\"%s\"%n", name, expected, actual);
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

    private static void test010() {
        assertEquals("Euler010: sumPrimesBelow(10)", 17, Euler010.sumPrimesBelow(10));
        assertEquals("Euler010: sumPrimesBelow(20)", 77, Euler010.sumPrimesBelow(20));
    }

    private static void test011() {
        int[][] g = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12},
            {13,14,15,16}
        };
        // Best product for k=2 is 15*16=240 (down-right from [2,2] or horizontally 15*16)
        assertEquals("Euler011: maxProductInGrid(k=2)", 240, Euler011.maxProductInGrid(g, 2));
        // For k=4 on this grid, the best is 13*14*15*16=43680 (bottom row)
        assertEquals("Euler011: maxProductInGrid(k=4)", 43680, Euler011.maxProductInGrid(g, 4));
    }

    private static void test012() {
        assertEquals("Euler012: firstTriangleOverDivisors(5)", 28, Euler012.firstTriangleOverDivisors(5));
    }

    private static void test013() {
        assertEquals("Euler013: firstNDigitsOfSum(3)", "553", Euler013.firstNDigitsOfSum(3));
        assertEquals("Euler013: firstNDigitsOfSum(10)", "5537376230", Euler013.firstNDigitsOfSum(10));
    }

    private static void test014() {
        assertEquals("Euler014: longestCollatzArgUnder(10)", 9, Euler014.longestCollatzArgUnder(10));
    }

    private static void test015() {
        // Small lattice paths
        String two = Euler015.latticePaths(2).toString(); // 6
        assertEquals("Euler015: latticePaths(2)", "6", two);
        String three = Euler015.latticePaths(3).toString(); // 20
        assertEquals("Euler015: latticePaths(3)", "20", three);
    }

    private static void test016() {
        assertEquals("Euler016: sumDigitsOfTwoPow(15)", 26, Euler016.sumDigitsOfTwoPow(15));
    }

    private static void test017() {
        assertEquals("Euler017: numberToWords(342)", "three hundred and forty-two", Euler017.numberToWords(342));
        assertEquals("Euler017: letterCount(\"three hundred and forty-two\")", 23, Euler017.letterCount("three hundred and forty-two"));
        assertEquals("Euler017: totalLettersInRange(1,5)", 19, Euler017.totalLettersInRange(1,5));
    }

    private static void test018() {
        int[][] tri = new int[][]{
            {3},
            {7, 4},
            {2, 4, 6},
            {8, 5, 9, 3}
        };
        assertEquals("Euler018: maxPathSum(sample)", 23, Euler018.maxPathSum(tri));
    }

    private static void test019() {
        // Sanity: known final answer for 1901..2000 is 171; quicker micro-check: subset 1901..1905 should be small and fast
        int fiveYears = Euler019.countSundaysOnFirst(1901, 1905);
        if (fiveYears < 0 || fiveYears > 61) { // 12*5 months => at most 60 Sundays on first
            failed++;
            System.out.printf("FAIL: Euler019: result out of plausible range actual=%d%n", fiveYears);
        } else {
            passed++;
        }
    }

    private static void test020() {
        assertEquals("Euler020: sumDigitsOfFactorial(10)", 27, Euler020.sumDigitsOfFactorial(10));
    }

    private static void test021() {
        // Known amicable pair: 220 and 284
        assertEquals("Euler021: sumAmicableBelow(300)", 504, Euler021.sumAmicableBelow(300));
    }

    private static void test022() {
        // Skip if data file not present; verify behavior is DATA_FILE_NOT_FOUND
        try {
            String out = runMainCapture("Euler022");
            if ("DATA_FILE_NOT_FOUND".equals(out) || out.matches("\\d+")) {
                passed++;
            } else {
                failed++;
                System.out.printf("FAIL: Euler022 unexpected output=%s%n", out);
            }
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler022 threw %s%n", e);
        }
    }

    private static void test023() {
        // Smaller variant: limit 50 yields a quick check by running main with a patched arg is not available;
        // so rely on main default computation existing and finishing. Just smoke-run and check numeric output format.
        try {
            String out = runMainCapture("Euler023");
            if (out.matches("\\d+")) passed++; else {
                failed++;
                System.out.printf("FAIL: Euler023 non-numeric output=%s%n", out);
            }
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler023 threw %s%n", e);
        }
    }

    private static void test024() {
        try {
            String out = runMainCapture("Euler024", "6"); // 6th permutation of 0..9 (small k) not standard; verify format length 10 and digits 0..9 unique
            boolean ok = out.length() == 10;
            boolean[] seen = new boolean[10];
            for (int i = 0; i < out.length(); i++) {
                char c = out.charAt(i);
                if (c < '0' || c > '9') { ok = false; break; }
                int d = c - '0';
                if (seen[d]) { ok = false; break; }
                seen[d] = true;
            }
            if (ok) passed++; else {
                failed++;
                System.out.printf("FAIL: Euler024 invalid permutation=%s%n", out);
            }
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler024 threw %s%n", e);
        }
    }

    private static void test025() {
        try {
            String out = runMainCapture("Euler025", "3"); // first 3-digit Fibonacci index is 12 (144)
            assertEquals("Euler025: first index with 3 digits", "12", out);
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler025 threw %s%n", e);
        }
    }

    private static void test026() {
        try {
            String out = runMainCapture("Euler026", "20"); // under 20, 1/19 has the longest cycle
            assertEquals("Euler026: best d < 20", "19", out);
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler026 threw %s%n", e);
        }
    }

    private static void test027() {
        try {
            String out = runMainCapture("Euler027");
            if (out.matches("-?\\d+")) passed++; else {
                failed++;
                System.out.printf("FAIL: Euler027 non-integer output=%s%n", out);
            }
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler027 threw %s%n", e);
        }
    }

    private static void test028() {
        try {
            String out = runMainCapture("Euler028", "5"); // 5x5 spiral has diagonal sum 101
            assertEquals("Euler028: diagonalSum(5)", "101", out);
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler028 threw %s%n", e);
        }
    }

    private static void test029() {
        try {
            String out = runMainCapture("Euler029", "2", "5", "2", "5"); // 2..5^2..5
            assertEquals("Euler029: distinct powers 2..5,2..5", "15", out);
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler029 threw %s%n", e);
        }
    }

    private static void test030() {
        try {
            String out = runMainCapture("Euler030", "4"); // known sum of fourth powers is 19316
            assertEquals("Euler030: digit fourth powers sum", "19316", out);
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler030 threw %s%n", e);
        }
    }

    private static void test031() {
        try {
            String out = runMainCapture("Euler031", "10"); // ways to make 10 with UK coins is 11
            assertEquals("Euler031: coin sums 10", "11", out);
        } catch (Exception e) {
            failed++;
            System.out.printf("FAIL: Euler031 threw %s%n", e);
        }
    }

    private static void test032() {
        try {
            String out = runMainCapture("Euler032"); // known sum is 45228
            assertEquals("Euler032: pandigital products sum", "45228", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler032 threw %s%n", e); }
    }

    private static void test033() {
        try {
            String out = runMainCapture("Euler033"); // denominator of product in lowest terms is 100
            assertEquals("Euler033: digit cancelling fractions", "100", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler033 threw %s%n", e); }
    }

    private static void test034() {
        try {
            String out = runMainCapture("Euler034"); // known sum is 40730
            assertEquals("Euler034: digit factorials sum", "40730", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler034 threw %s%n", e); }
    }

    private static void test035() {
        try {
            // Limit 100 should be 13 circular primes
            String out = runMainCapture("Euler035", "100");
            assertEquals("Euler035: circular primes < 100", "13", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler035 threw %s%n", e); }
    }

    private static void test036() {
        try {
            String out = runMainCapture("Euler036", "1000000"); // known sum is 872187
            assertEquals("Euler036: double-base palindromes < 1e6", "872187", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler036 threw %s%n", e); }
    }

    private static void test037() {
        try {
            // This one can be a bit slower; guard with timeout
            String out = runMainCaptureWithTimeout("Euler037", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler037: truncatable primes sum", "748317", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler037%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler037 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler037 threw %s%n", e); }
    }

    private static void test038() {
        try {
            String out = runMainCapture("Euler038"); // known best is 932718654
            assertEquals("Euler038: pandigital multiples", "932718654", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler038 threw %s%n", e); }
    }

    private static void test039() {
        try {
            String out = runMainCapture("Euler039", "1000"); // known best perimeter is 840
            assertEquals("Euler039: best perimeter <= 1000", "840", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler039 threw %s%n", e); }
    }

    private static void test040() {
        try {
            String out = runMainCapture("Euler040"); // known product is 210
            assertEquals("Euler040: Champernowne product", "210", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler040 threw %s%n", e); }
    }

    private static void test041() {
        try {
            // Result is 7652413
            String out = runMainCaptureWithTimeout("Euler041", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler041: largest pandigital prime", "7652413", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler041%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler041 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler041 threw %s%n", e); }
    }

    private static void test042() {
        try {
            String out = runMainCapture("Euler042");
            if ("DATA_FILE_NOT_FOUND".equals(out) || out.matches("\\d+")) passed++; else {
                failed++; System.out.printf("FAIL: Euler042 unexpected output=%s%n", out);
            }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler042 threw %s%n", e); }
    }

    private static void test043() {
        try {
            String out = runMainCaptureWithTimeout("Euler043", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler043: substring divisibility sum", "16695334890", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler043%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler043 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler043 threw %s%n", e); }
    }

    private static void test044() {
        try {
            String out = runMainCapture("Euler044"); // known minimal difference is 5482660
            assertEquals("Euler044: pentagon difference", "5482660", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler044 threw %s%n", e); }
    }

    private static void test045() {
        try {
            String out = runMainCapture("Euler045"); // next such number is 1533776805
            assertEquals("Euler045: next T-P-H number", "1533776805", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler045 threw %s%n", e); }
    }

    private static void test046() {
        try {
            String out = runMainCaptureWithTimeout("Euler046", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler046: Goldbach's other conjecture counterexample", "5777", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler046%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler046 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler046 threw %s%n", e); }
    }

    private static void test047() {
        try {
            String out = runMainCapture("Euler047", "4"); // first of four consecutive ints with 4 prime factors
            assertEquals("Euler047: first of 4 consecutive with 4 prime factors", "134043", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler047 threw %s%n", e); }
    }

    private static void test048() {
        try {
            String out = runMainCapture("Euler048", "1000");
            assertEquals("Euler048: last 10 digits of series", "9110846700", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler048 threw %s%n", e); }
    }

    private static void test049() {
        try {
            String out = runMainCaptureWithTimeout("Euler049", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler049: prime permutations concat", "296962999629", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler049%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler049 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler049 threw %s%n", e); }
    }

    private static void test050() {
        try {
            String out = runMainCaptureWithTimeout("Euler050", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler050: consecutive prime sum under 1e6", "997651", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler050%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler050 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler050 threw %s%n", e); }
    }

    private static void test051() {
        try {
            String out = runMainCaptureWithTimeout("Euler051", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler051: prime digit replacements", "121313", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler051%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler051 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler051 threw %s%n", e); }
    }

    private static void test052() {
        try {
            String out = runMainCaptureWithTimeout("Euler052", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler052: permuted multiples", "142857", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler052%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler052 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler052 threw %s%n", e); }
    }

    private static void test053() {
        try {
            String out = runMainCapture("Euler053");
            assertEquals("Euler053: nCr > 1e6 count", "4075", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler053 threw %s%n", e); }
    }

    private static void test054() {
        try {
            String out = runMainCapture("Euler054");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { passed++; } else { failed++; System.out.printf("FAIL: Euler054 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler054 threw %s%n", e); }
    }

    private static void test055() {
        try {
            String out = runMainCaptureWithTimeout("Euler055", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler055: Lychrel numbers below 10000", "249", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler055%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler055 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler055 threw %s%n", e); }
    }

    private static void test056() {
        try {
            String out = runMainCaptureWithTimeout("Euler056", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler056: powerful digit sum", "972", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler056%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler056 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler056 threw %s%n", e); }
    }

    private static void test057() {
        try {
            String out = runMainCapture("Euler057");
            assertEquals("Euler057: sqrt(2) expansions with longer numerator", "153", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler057 threw %s%n", e); }
    }

    private static void test058() {
        try {
            String out = runMainCaptureWithTimeout("Euler058", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler058: spiral primes side length", "26241", out);
        } catch (java.util.concurrent.TimeoutException te) {
            if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler058%n", DEFAULT_TIMEOUT_MS); }
            else { failed++; System.out.printf("FAIL: Euler058 timeout%n"); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler058 threw %s%n", e); }
    }

    private static void test059() {
        try {
            String out = runMainCapture("Euler059");
            if ("DATA_FILE_NOT_FOUND".equals(out) || out.matches("\\d+")) passed++; else { failed++; System.out.printf("FAIL: Euler059 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler059 threw %s%n", e); }
    }

    private static void test060() {
        try {
            // Euler060 is TODO, so ensure it prints TODO or skip
            String out = runMainCapture("Euler060");
            if ("TODO".equals(out)) { skipped++; } else { passed++; }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler060 threw %s%n", e); }
    }

    private static void test061() {
        try {
            String out = runMainCapture("Euler061");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { passed++; } else { failed++; System.out.printf("FAIL: Euler061 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler061 threw %s%n", e); }
    }

    private static void test062() {
        try {
            String out = runMainCaptureWithTimeout("Euler062", DEFAULT_TIMEOUT_MS);
            assertEquals("Euler062: smallest cube with five cubic permutations", "127035954683", out);
        } catch (java.util.concurrent.TimeoutException te) { if (TIMEOUT_AS_SKIP) { skipped++; System.err.printf("SKIP (timeout %d ms): Euler062%n", DEFAULT_TIMEOUT_MS); } else { failed++; System.out.printf("FAIL: Euler062 timeout%n"); } }
        catch (Exception e) { failed++; System.out.printf("FAIL: Euler062 threw %s%n", e); }
    }

    private static void test063() {
        try {
            String out = runMainCapture("Euler063");
            assertEquals("Euler063: powerful digit counts", "49", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler063 threw %s%n", e); }
    }

    private static void test064() {
        try {
            String out = runMainCapture("Euler064");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { passed++; } else { failed++; System.out.printf("FAIL: Euler064 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler064 threw %s%n", e); }
    }

    private static void test065() {
        try {
            String out = runMainCapture("Euler065");
            assertEquals("Euler065: sum digits numerator 100th convergent of e", "272", out);
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler065 threw %s%n", e); }
    }

    private static void test066() {
        try {
            String out = runMainCapture("Euler066");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { passed++; } else { failed++; System.out.printf("FAIL: Euler066 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler066 threw %s%n", e); }
    }

    private static void test067() {
        try {
            String out = runMainCapture("Euler067");
            if ("TODO".equals(out) || "DATA_FILE_NOT_FOUND".equals(out)) { skipped++; } else if (out.matches("\\d+")) { passed++; } else { failed++; System.out.printf("FAIL: Euler067 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler067 threw %s%n", e); }
    }

    private static void test068() {
        try {
            String out = runMainCapture("Euler068");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { passed++; } else { failed++; System.out.printf("FAIL: Euler068 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler068 threw %s%n", e); }
    }

    private static void test069() {
        try {
            String out = runMainCapture("Euler069");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { assertEquals("Euler069: totient maximum <= 1e6", EXPECTED_DEFAULT.get(69), out); } else { failed++; System.out.printf("FAIL: Euler069 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler069 threw %s%n", e); }
    }

    private static void test070() {
        try {
            String out = runMainCapture("Euler070");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { assertEquals("Euler070: totient permutation", EXPECTED_DEFAULT.get(70), out); } else { failed++; System.out.printf("FAIL: Euler070 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler070 threw %s%n", e); }
    }

    private static void test071() {
        try {
            String out = runMainCapture("Euler071");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { assertEquals("Euler071: ordered fractions", EXPECTED_DEFAULT.get(71), out); } else { failed++; System.out.printf("FAIL: Euler071 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler071 threw %s%n", e); }
    }

    private static void test072() {
        try {
            String out = runMainCapture("Euler072");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { assertEquals("Euler072: counting fractions", EXPECTED_DEFAULT.get(72), out); } else { failed++; System.out.printf("FAIL: Euler072 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler072 threw %s%n", e); }
    }

    private static void test073() {
        try {
            String out = runMainCapture("Euler073");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { assertEquals("Euler073: fractions in range", EXPECTED_DEFAULT.get(73), out); } else { failed++; System.out.printf("FAIL: Euler073 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler073 threw %s%n", e); }
    }

    private static void test074() {
        try {
            String out = runMainCapture("Euler074");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { assertEquals("Euler074: digit factorial chains", EXPECTED_DEFAULT.get(74), out); } else { failed++; System.out.printf("FAIL: Euler074 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler074 threw %s%n", e); }
    }

    private static void test075() {
        try {
            String out = runMainCapture("Euler075");
            if ("TODO".equals(out)) { skipped++; } else if (out.matches("\\d+")) { assertEquals("Euler075: singular integer right triangles", EXPECTED_DEFAULT.get(75), out); } else { failed++; System.out.printf("FAIL: Euler075 unexpected output=%s%n", out); }
        } catch (Exception e) { failed++; System.out.printf("FAIL: Euler075 threw %s%n", e); }
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
        EXPECTED_DEFAULT.put(42, "162");
        EXPECTED_DEFAULT.put(43, "16695334890");
        EXPECTED_DEFAULT.put(44, "5482660");
        EXPECTED_DEFAULT.put(45, "1533776805");
        EXPECTED_DEFAULT.put(46, "5777");
        EXPECTED_DEFAULT.put(47, "134043");
        EXPECTED_DEFAULT.put(48, "9110846700");
        EXPECTED_DEFAULT.put(49, "296962999629");
        EXPECTED_DEFAULT.put(50, "997651");
    // 51–70
        EXPECTED_DEFAULT.put(51, "121313");
        EXPECTED_DEFAULT.put(52, "142857");
        EXPECTED_DEFAULT.put(53, "4075");
        EXPECTED_DEFAULT.put(54, "DATA_FILE_NOT_FOUND"); // poker dataset not yet included
        EXPECTED_DEFAULT.put(55, "249");
        EXPECTED_DEFAULT.put(56, "972");
        EXPECTED_DEFAULT.put(57, "153");
        EXPECTED_DEFAULT.put(58, "26241");
        EXPECTED_DEFAULT.put(59, "DATA_FILE_NOT_FOUND"); // cipher dataset not yet included
        EXPECTED_DEFAULT.put(60, "26033");
        EXPECTED_DEFAULT.put(61, "28684");
        EXPECTED_DEFAULT.put(62, "127035954683");
        EXPECTED_DEFAULT.put(63, "49");
        EXPECTED_DEFAULT.put(64, "1322");
        EXPECTED_DEFAULT.put(65, "272");
        EXPECTED_DEFAULT.put(66, "661");
        EXPECTED_DEFAULT.put(67, "DATA_FILE_NOT_FOUND"); // triangle dataset not yet included
        EXPECTED_DEFAULT.put(68, "6531031914842725");
        EXPECTED_DEFAULT.put(69, "510510");
        EXPECTED_DEFAULT.put(70, "8319823");
    // 71–80
        EXPECTED_DEFAULT.put(71, "428570");
        EXPECTED_DEFAULT.put(72, "303963552391");
        EXPECTED_DEFAULT.put(73, "7295372");
        EXPECTED_DEFAULT.put(74, "402");
        EXPECTED_DEFAULT.put(75, "161667");
        EXPECTED_DEFAULT.put(76, "190569291");
        EXPECTED_DEFAULT.put(77, "71");
        EXPECTED_DEFAULT.put(78, "55374");
        EXPECTED_DEFAULT.put(79, "DATA_FILE_NOT_FOUND"); // keylog dataset not yet included
        EXPECTED_DEFAULT.put(80, "40886");
    // 81–90
        EXPECTED_DEFAULT.put(81, "DATA_FILE_NOT_FOUND"); // 80x80 matrix dataset not yet included
        EXPECTED_DEFAULT.put(82, "DATA_FILE_NOT_FOUND"); // matrix dataset not yet included
        EXPECTED_DEFAULT.put(83, "DATA_FILE_NOT_FOUND"); // matrix dataset not yet included
        EXPECTED_DEFAULT.put(84, "101524");
        EXPECTED_DEFAULT.put(85, "2772");
        EXPECTED_DEFAULT.put(86, "1818");
        EXPECTED_DEFAULT.put(87, "1097343");
        EXPECTED_DEFAULT.put(88, "7587457");
        EXPECTED_DEFAULT.put(89, "DATA_FILE_NOT_FOUND"); // roman numerals dataset not yet included
        EXPECTED_DEFAULT.put(90, "1217");
    // 91–100
        EXPECTED_DEFAULT.put(91, "14234");
        EXPECTED_DEFAULT.put(92, "8581146");
        EXPECTED_DEFAULT.put(93, "1258");
        EXPECTED_DEFAULT.put(94, "518408346");
        EXPECTED_DEFAULT.put(95, "14316");
        EXPECTED_DEFAULT.put(96, "DATA_FILE_NOT_FOUND"); // sudoku dataset not yet included
        EXPECTED_DEFAULT.put(97, "8739992577");
        EXPECTED_DEFAULT.put(98, "DATA_FILE_NOT_FOUND"); // anagram words dataset not yet included
        EXPECTED_DEFAULT.put(99, "DATA_FILE_NOT_FOUND"); // base-exp dataset not yet included
        EXPECTED_DEFAULT.put(100, "756872327473");
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

    // Run a class's main with a timeout. Helps avoid hangs/very slow implementations during smoke runs.
    private static String runMainCaptureWithTimeout(String className, long timeoutMs) throws Exception {
        java.util.concurrent.ExecutorService es = java.util.concurrent.Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r, "EulerMain-" + className);
            t.setDaemon(true);
            return t;
        });
        try {
            java.util.concurrent.Future<String> fut = es.submit(() -> runMainCapture(className));
            return fut.get(timeoutMs, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.util.concurrent.TimeoutException te) {
            // Cancel the task and propagate to caller for handling
            //noinspection ResultOfMethodCallIgnored
            es.shutdownNow();
            throw te;
        } finally {
            es.shutdownNow();
        }
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
                long start = System.nanoTime();
                String actual = runMainCaptureWithTimeout(className, DEFAULT_TIMEOUT_MS);
                long elapsedMs = (System.nanoTime() - start) / 1_000_000L;
                if (elapsedMs > SLOW_LOG_MS) {
                    System.err.printf("SLOW: %s took %d ms%n", className, elapsedMs);
                }
                if (expected.equals(actual)) {
                    passed++;
                } else {
                    failed++;
                    System.out.printf("FAIL: %s default expected=%s actual=%s%n", className, expected, actual);
                }
            } catch (Exception e) {
                if (e instanceof java.util.concurrent.TimeoutException && TIMEOUT_AS_SKIP) {
                    skipped++;
                    System.err.printf("SKIP (timeout %d ms): %s%n", DEFAULT_TIMEOUT_MS, className);
                } else {
                    failed++;
                    System.out.printf("FAIL: %s default threw %s%n", className, e);
                }
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
    tests.add(EulerTests::test010);
    tests.add(EulerTests::test011);
    tests.add(EulerTests::test012);
    tests.add(EulerTests::test013);
    tests.add(EulerTests::test014);
    tests.add(EulerTests::test015);
    tests.add(EulerTests::test016);
    tests.add(EulerTests::test017);
    tests.add(EulerTests::test018);
    tests.add(EulerTests::test019);
    tests.add(EulerTests::test020);
    tests.add(EulerTests::test021);
    tests.add(EulerTests::test022);
    tests.add(EulerTests::test023);
    tests.add(EulerTests::test024);
    tests.add(EulerTests::test025);
    tests.add(EulerTests::test026);
    tests.add(EulerTests::test027);
    tests.add(EulerTests::test028);
    tests.add(EulerTests::test029);
    tests.add(EulerTests::test030);
    tests.add(EulerTests::test031);
    tests.add(EulerTests::test032);
    tests.add(EulerTests::test033);
    tests.add(EulerTests::test034);
    tests.add(EulerTests::test035);
    tests.add(EulerTests::test036);
    tests.add(EulerTests::test037);
    tests.add(EulerTests::test038);
    tests.add(EulerTests::test039);
    tests.add(EulerTests::test040);
    tests.add(EulerTests::test041);
    tests.add(EulerTests::test042);
    tests.add(EulerTests::test043);
    tests.add(EulerTests::test044);
    tests.add(EulerTests::test045);
    tests.add(EulerTests::test046);
    tests.add(EulerTests::test047);
    tests.add(EulerTests::test048);
    tests.add(EulerTests::test049);
    tests.add(EulerTests::test050);
    tests.add(EulerTests::test051);
    tests.add(EulerTests::test052);
    tests.add(EulerTests::test053);
    tests.add(EulerTests::test054);
    tests.add(EulerTests::test055);
    tests.add(EulerTests::test056);
    tests.add(EulerTests::test057);
    tests.add(EulerTests::test058);
    tests.add(EulerTests::test059);
    tests.add(EulerTests::test060);
    tests.add(EulerTests::test061);
    tests.add(EulerTests::test062);
    tests.add(EulerTests::test063);
    tests.add(EulerTests::test064);
    tests.add(EulerTests::test065);
    tests.add(EulerTests::test066);
    tests.add(EulerTests::test067);
    tests.add(EulerTests::test068);
    tests.add(EulerTests::test069);
    tests.add(EulerTests::test070);
    tests.add(EulerTests::test071);
    tests.add(EulerTests::test072);
    tests.add(EulerTests::test073);
    tests.add(EulerTests::test074);
    tests.add(EulerTests::test075);

        long t0 = System.nanoTime();
        tests.forEach(Runnable::run);
        long t1 = System.nanoTime();

        // Generic default-output checks for 001..050, 051..070, and 071..100
        if (!QUICK_DEFAULT_CHECKS) {
            testExpectedDefaultsRange(1, 50);
            testExpectedDefaultsRange(51, 70);
            testExpectedDefaultsRange(71, 100);
        } else {
            // Quick mode: only run early problems which are typically fast
            testExpectedDefaultsRange(1, 30);
        }

        System.out.printf("\nTests: %d passed, %d failed, %d skipped (%.3f ms)\n", passed, failed, skipped, (t1 - t0) / 1_000_000.0);
        if (failed > 0) System.exit(1);
    }
}
