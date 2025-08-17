// Euler 090: Cube digit pairs
// How many distinct arrangements of two cubes allow for the display of all square numbers below 100?
// https://projecteuler.net/problem=90
public final class Euler090 {
    public static void main(String[] args) {
        // Precompute all 6-digit subsets (bitmasks 0..(1<<10)) with size 6
        java.util.ArrayList<Integer> sets = new java.util.ArrayList<>();
        for (int mask = 0; mask < (1 << 10); mask++) {
            if (Integer.bitCount(mask) == 6) sets.add(mask);
        }
        // Required square pairs
        int[][] pairs = new int[][]{
            {0,1},{0,4},{0,9},{1,6},{2,5},{3,6},{4,9},{6,4},{8,1}
        };
        int count = 0;
        for (int i = 0; i < sets.size(); i++) {
            int a = sets.get(i);
            for (int j = i; j < sets.size(); j++) {
                int b = sets.get(j);
                if (canDisplayAll(a, b, pairs)) count++;
            }
        }
        System.out.println(count);
    }

    private static boolean has(int mask, int d) {
        if (d == 6 || d == 9) {
            // 6 and 9 are interchangeable
            return ((mask & (1 << 6)) != 0) || ((mask & (1 << 9)) != 0);
        }
        return (mask & (1 << d)) != 0;
    }

    private static boolean canDisplayAll(int a, int b, int[][] pairs) {
        for (int[] p : pairs) {
            int x = p[0], y = p[1];
            boolean ok = (has(a, x) && has(b, y)) || (has(a, y) && has(b, x));
            if (!ok) return false;
        }
        return true;
    }
}
