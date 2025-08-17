// Euler 085: Counting rectangles
// Investigate the number of rectangles in a grid; find the grid with a number of rectangles closest to two million.
// https://projecteuler.net/problem=85
public final class Euler085 {
    public static void main(String[] args) {
        final long TARGET = 2_000_000L;
        int bestM = 0, bestN = 0; long bestDiff = Long.MAX_VALUE;
        // Heuristic bounds: rectangles ~ (m^2/2)*(n^2/2) -> mn ~ sqrt(4*TARGET)
        int maxSide = 3000; // ample upper bound
        long[] tri = new long[maxSide + 1];
        for (int i = 0; i <= maxSide; i++) tri[i] = (long)i * (i + 1) / 2;
        for (int m = 1; m <= 3000; m++) {
            long tm = tri[m];
            // Binary search n to get near TARGET/tm
            int lo = 1, hi = 3000;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                long val = tm * tri[mid];
                if (val < TARGET) lo = mid + 1; else hi = mid;
            }
            // Check candidates around lo
            for (int n = Math.max(1, lo - 2); n <= Math.min(3000, lo + 2); n++) {
                long rects = tm * tri[n];
                long diff = Math.abs(rects - TARGET);
                if (diff < bestDiff || (diff == bestDiff && (long)m * n < (long)bestM * bestN)) {
                    bestDiff = diff; bestM = m; bestN = n;
                }
                if (tm * tri[n] > TARGET && n > lo + 2) break; // optional early stop
            }
            // Optional pruning: if tri[m]*tri[1] already exceeds TARGET + bestDiff, we can break
            if (tm * tri[1] - TARGET > bestDiff) break;
        }
        System.out.println((long)bestM * bestN);
    }
}
