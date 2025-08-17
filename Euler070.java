// Euler 070: Totient permutation
// Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and n/φ(n) produces a minimum.
// https://projecteuler.net/problem=70
public final class Euler070 {
    private static boolean isPermutation(int a, int b) {
        int[] cnt = new int[10];
        while (a > 0) { cnt[a % 10]++; a /= 10; }
        while (b > 0) { cnt[b % 10]--; b /= 10; }
        for (int c : cnt) if (c != 0) return false; return true;
    }

    private static int[] primesUpTo(int n) {
        boolean[] is = new boolean[n + 1];
        java.util.Arrays.fill(is, true);
        if (n >= 0) is[0] = false; if (n >= 1) is[1] = false;
        for (int p = 2; p * p <= n; p++) if (is[p]) for (int q = p * p; q <= n; q += p) is[q] = false;
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        for (int i = 2; i <= n; i++) if (is[i]) list.add(i);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        final int LIMIT = 10_000_000;
        int[] primes = primesUpTo(100_000);
        double bestRatio = Double.MAX_VALUE; int bestN = 0;
        // Heuristic: best n is product of two primes of similar size
        for (int i = 0; i < primes.length; i++) {
            long p = primes[i]; if (p * p >= LIMIT) break;
            for (int j = i + 1; j < primes.length; j++) {
                long q = primes[j]; long n = p * q; if (n >= LIMIT) break;
                long phi = (p - 1) * (q - 1);
                if (isPermutation((int) n, (int) phi)) {
                    double ratio = n / (double) phi;
                    if (ratio < bestRatio) { bestRatio = ratio; bestN = (int) n; }
                }
            }
        }
        System.out.println(bestN);
    }
}
