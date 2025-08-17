// Euler 078: Coin partitions
// Find the least value of n for which p(n) is divisible by one million.
// https://projecteuler.net/problem=78
public final class Euler078 {
    public static void main(String[] args) {
        final int MOD = 1_000_000;
        // Partition numbers p(n) via generalized pentagonal numbers, modulo 1e6
        int capacity = 60000; // known answer is 55374; ensure enough room
        int[] p = new int[capacity + 1];
        p[0] = 1;
        for (int n = 1; n <= capacity; n++) {
            long sum = 0;
            for (int k = 1;; k++) {
                int g1 = k * (3 * k - 1) / 2;
                int g2 = k * (3 * k + 1) / 2;
                if (g1 > n && g2 > n) break;
                int sign = (k % 2 == 1) ? 1 : -1;
                if (g1 <= n) sum += sign * (long)p[n - g1];
                if (g2 <= n) sum += sign * (long)p[n - g2];
            }
            int val = (int)(sum % MOD);
            if (val < 0) val += MOD;
            p[n] = val;
            if (p[n] == 0) { System.out.println(n); return; }
        }
        // If not found within capacity, print TODO to indicate unmet search range in this environment
        System.out.println("TODO");
    }
}
