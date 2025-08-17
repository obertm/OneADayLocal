// Euler 044: Pentagon numbers
public final class Euler044 {
    private static long pent(long n) { return n * (3 * n - 1) / 2; }
    private static boolean isPent(long x) {
        // Solve 3n^2 - n - 2x = 0 -> n = (1 + sqrt(1+24x))/6
        double n = (1 + Math.sqrt(1 + 24.0 * x)) / 6.0;
        return Math.abs(n - Math.round(n)) < 1e-12;
    }

    public static void main(String[] args) {
        long best = Long.MAX_VALUE;
        for (int j = 2; j < 5000; j++) { // limit is enough
            long pj = pent(j);
            for (int k = j - 1; k >= 1; k--) {
                long pk = pent(k);
                long d = pj - pk;
                if (d >= best) break;
                if (isPent(pj + pk) && isPent(d)) {
                    best = d; break;
                }
            }
        }
        System.out.println(best);
    }
}
