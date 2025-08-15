// Euler 010: Summation of primes
public final class Euler010 {
    public static long sumPrimesBelow(int n) {
        if (n <= 2) return 0L;
        boolean[] comp = new boolean[n];
        long sum = 2; // include 2
        int limit = (int) Math.sqrt(n - 1);
        // Sieve odds only
        for (int p = 3; p < n; p += 2) {
            if (!comp[p]) {
                sum += p;
                if (p <= limit) {
                    for (int m = p * p; m < n; m += 2 * p) comp[m] = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 2_000_000;
        if (args.length > 0) n = Integer.parseInt(args[0]);
        System.out.println(sumPrimesBelow(n));
    }
}
