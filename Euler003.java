public final class Euler003 {
    /**
     * Returns the largest prime factor of n. Assumes n >= 2.
     */
    public static long largestPrimeFactor(long n) {
        long largest = -1;
        // Factor out 2s
        while ((n & 1) == 0) {
            largest = 2;
            n >>= 1;
        }
        // Factor out odd primes
        long f = 3;
        while (f * f <= n) {
            while (n % f == 0) {
                largest = f;
                n /= f;
            }
            f += 2;
        }
        // If remaining n > 1, it's prime
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
