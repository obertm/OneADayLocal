// Euler 088: Product-sum numbers
// For 2 ≤ k ≤ 12000, find the minimal product-sum numbers and calculate their sum of distinct values.
// https://projecteuler.net/problem=88
public final class Euler088 {
    public static void main(String[] args) {
        int K = 12_000; // default
        if (args != null && args.length > 0) {
            try { K = Integer.parseInt(args[0]); } catch (Exception ignore) {}
        }
        int limit = 2 * K; // upper bound on minimal product-sum values

        int[] minN = new int[K + 1];
        java.util.Arrays.fill(minN, Integer.MAX_VALUE);

        // DFS over non-decreasing factor combinations (>=2)
        dfs(2, 1, 0, 0, K, limit, minN);

        java.util.HashSet<Integer> unique = new java.util.HashSet<>();
        for (int k = 2; k <= K; k++) {
            unique.add(minN[k]);
        }
        long sum = 0;
        for (int v : unique) sum += v;
        System.out.println(sum);
    }

    private static void dfs(int start, int prod, int sum, int len, int K, int limit, int[] minN) {
        // Compute k for current factor multiset by padding with ones:
        // k = len + (prod - sum)
        int k = len + (prod - sum);
        if (k >= 2 && k <= K) {
            if (prod < minN[k]) minN[k] = prod;
        }
        if (k > K) return; // further factors only increase k (once prod >= 2)
        // Try extending with next factor f >= start
        int maxF = limit / prod;
        for (int f = start; f <= maxF; f++) {
            long newProdL = (long) prod * f;
            if (newProdL > limit) break;
            int newProd = (int) newProdL;
            int newSum = sum + f;
            // Prune: even if k grows, product increases; still safe as we bound by limit
            dfs(f, newProd, newSum, len + 1, K, limit, minN);
        }
    }
}
