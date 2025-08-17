// Euler 061: Cyclical figurate numbers
// Find the sum of the only ordered set of six cyclic 4-digit numbers for 3..8-gonal numbers.
// https://projecteuler.net/problem=61
import java.util.*;

public final class Euler061 {
    private static final int[] TYPES = {3,4,5,6,7,8};

    public static void main(String[] args) {
        // Generate candidates per type: 4-digit numbers with last two digits >= 10
        Map<Integer, Map<Integer, List<Integer>>> forward = new HashMap<>(); // type -> prefix -> list
        for (int t : TYPES) {
            List<Integer> list = polygonals(t);
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int v : list) {
                int pref = v / 100;
                map.computeIfAbsent(pref, k -> new ArrayList<>()).add(v);
            }
            forward.put(t, map);
        }

    // Backtrack across types ensuring cyclic 2-digit link (allow any permutation of types)
    int result = search(forward);
        System.out.println(result);
    }

    private static List<Integer> polygonals(int type) {
        List<Integer> res = new ArrayList<>();
        for (int n = 1; ; n++) {
            int v;
            switch (type) {
                case 3: v = n * (n + 1) / 2; break;              // triangle
                case 4: v = n * n; break;                         // square
                case 5: v = n * (3 * n - 1) / 2; break;           // pentagonal
                case 6: v = n * (2 * n - 1); break;               // hexagonal
                case 7: v = n * (5 * n - 3) / 2; break;           // heptagonal
                case 8: v = n * (3 * n - 2); break;               // octagonal
                default: throw new IllegalArgumentException();
            }
            if (v > 9999) break;
            if (v >= 1000 && (v % 100) >= 10) res.add(v);
        }
        return res;
    }

    private static int search(Map<Integer, Map<Integer, List<Integer>>> forward) {
        // Heuristic order by candidate count to reduce branching, but we'll try all permutations via bitmask
        Integer[] types = new Integer[TYPES.length];
        for (int i = 0; i < TYPES.length; i++) types[i] = TYPES[i];
        java.util.Arrays.sort(types, java.util.Comparator.comparingInt(t ->
            forward.get(t).values().stream().mapToInt(java.util.List::size).sum()
        ));
        boolean[] usedVal = new boolean[10000];
        int fullMask = (1 << types.length) - 1;
        return dfsStart(types, forward, usedVal, fullMask);
    }

    private static int dfsStart(Integer[] types, Map<Integer, Map<Integer, List<Integer>>> forward,
                                boolean[] usedVal, int mask) {
        // Choose any starting type and any of its values
        for (int i = 0; i < types.length; i++) {
            int type = types[i];
            if ((mask & (1 << i)) == 0) continue;
            for (List<Integer> lst : forward.get(type).values()) {
                for (int v : lst) {
                    if (usedVal[v]) continue;
                    usedVal[v] = true;
                    int pref = v / 100, suff = v % 100;
                    int got = dfsNext(types, forward, usedVal, mask ^ (1 << i), pref, suff, v, pref, 1);
                    usedVal[v] = false;
                    if (got != -1) return got;
                }
            }
        }
        return -1;
    }

    // depth counts how many elements are in the chain so far
    private static int dfsNext(Integer[] types, Map<Integer, Map<Integer, List<Integer>>> forward,
                               boolean[] usedVal, int mask, int firstPrefix, int prevSuffix,
                               int sum, int startPrefix, int depth) {
        if (mask == 0) {
            // Close the loop: last suffix must equal first prefix
            return (prevSuffix == firstPrefix) ? sum : -1;
        }
        // If only one type remains, we can enforce closure in selection
        if ((mask & (mask - 1)) == 0) {
            int i = Integer.numberOfTrailingZeros(mask);
            int type = types[i];
            List<Integer> cand = forward.get(type).get(prevSuffix);
            if (cand == null) return -1;
            for (int v : cand) {
                if (usedVal[v]) continue;
                if ((v % 100) != firstPrefix) continue;
                return sum + v;
            }
            return -1;
        }
        // Try each remaining type whose prefix matches prevSuffix
        for (int i = 0; i < types.length; i++) {
            if ((mask & (1 << i)) == 0) continue;
            int type = types[i];
            List<Integer> cand = forward.get(type).get(prevSuffix);
            if (cand == null) continue;
            for (int v : cand) {
                if (usedVal[v]) continue;
                usedVal[v] = true;
                int got = dfsNext(types, forward, usedVal, mask ^ (1 << i), firstPrefix, v % 100,
                                   sum + v, startPrefix, depth + 1);
                usedVal[v] = false;
                if (got != -1) return got;
            }
        }
        return -1;
    }
}
