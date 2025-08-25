public final class Euler003 {
    /**
     * Returns the largest prime factor of n. Assumes n >= 2.
     */
    public static long largestPrimeFactor(long n) {
        if (n < 2) throw new IllegalArgumentException("n must be >= 2");

        long largest = -1;

        // Remove factor 2 completely.
        while ((n & 1L) == 0L) {
            largest = 2L;
            n >>= 1; // divide by 2
        }
        if (n == 1) return largest; // n was a power of 2

        // Remove factor 3 completely.
        while (n % 3L == 0L) {
            largest = 3L;
            n /= 3L;
        }
        if (n == 1) return largest;

        // Use 6k ± 1 wheel: all primes > 3 are of this form.
        // Iterate pair (f, f+2) where f = 6k - 1.
        for (long f = 5; f <= n / f; f += 6) {
            while (n % f == 0L) {
                largest = f;
                n /= f;
            }
            long f2 = f + 2; // 6k + 1
            while (n % f2 == 0L) {
                largest = f2;
                n /= f2;
            }
        }
        // Whatever remains (if >1) is prime.
        if (n > 1) largest = n;
        return largest;
    }

    public static void main(String[] args) {
        long n = 600_851_475_143L;
        if (args.length > 0) {
            n = Long.parseLong(args[0]);
        }
        System.out.println(largestPrimeFactor(n));
    }
}
