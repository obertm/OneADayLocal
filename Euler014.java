// Euler 014: Longest Collatz sequence
public final class Euler014 {
    private static int collatzLength(long start, int[] cache, java.util.HashMap<Long, Integer> bigCache) {
        if (start == 1) return 1;
        if (start < cache.length && cache[(int)start] != 0) return cache[(int)start];
        Integer bc = bigCache.get(start);
        if (bc != null) return bc;

        java.util.ArrayList<Long> seen = new java.util.ArrayList<>();
        long n = start;
        int steps = 0;
        while (true) {
            if (n < cache.length && cache[(int)n] != 0) { steps += cache[(int)n]; break; }
            if (n == 1) { steps += 1; break; }
            seen.add(n);
            if ((n & 1L) == 0) n >>= 1; else n = 3 * n + 1;
            steps++;
        }
        int len = steps;
        for (int i = 0; i < seen.size(); i++) {
            long v = seen.get(i);
            if (v < cache.length) {
                if (cache[(int)v] == 0) cache[(int)v] = len;
            } else {
                bigCache.putIfAbsent(v, len);
            }
            len--;
        }
        // Return from cache or bigCache to avoid mismatches
        if (start < cache.length) return cache[(int)start];
        return bigCache.getOrDefault(start, steps);
    }

    public static int longestCollatzArgUnder(int limit) {
        int[] cache = new int[limit + 1];
        cache[1] = 1;
        java.util.HashMap<Long, Integer> bigCache = new java.util.HashMap<>();
        int bestN = 1;
        int bestLen = 1;
        for (int i = 2; i < limit; i++) {
            int len = collatzLength(i, cache, bigCache);
            if (len > bestLen) { bestLen = len; bestN = i; }
        }
        return bestN;
    }

    public static void main(String[] args) {
        int limit = 1_000_000;
        if (args != null && args.length > 0) {
            try { limit = Integer.parseInt(args[0]); } catch (Exception ignored) {}
        }
        System.out.println(longestCollatzArgUnder(limit));
    }
}
