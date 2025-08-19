public final class Euler001 {
    // Sum of multiples of 3 or 5 below N
    public static long sumMultiples3or5Below(int n) {
        return sumMultiples3or5BelowFormula(n);
    }

    // O(1) inclusion–exclusion using arithmetic progression sums
    private static long sumMultiples3or5BelowFormula(long n) {
        if (n <= 1) return 0L;
        long n1 = n - 1;
        long k3 = n1 / 3;
        long k5 = n1 / 5;
        long k15 = n1 / 15;
        long s3 = 3L * k3 * (k3 + 1) / 2L;
        long s5 = 5L * k5 * (k5 + 1) / 2L;
        long s15 = 15L * k15 * (k15 + 1) / 2L;
        return s3 + s5 - s15;
    }

    public static void main(String[] args) {
        int limit = 1000;
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
        System.out.println(sumMultiples3or5Below(limit));
    }
}
