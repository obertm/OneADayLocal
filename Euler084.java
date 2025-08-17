// Euler 084: Monopoly odds with two 4-sided dice
// Compute stationary distribution over Monopoly board squares using a Markov chain
// with state (position 0..39, doubles streak 0..2). Handle CC/CH decks as uniform draws.
// Output the concatenation of the indices (2-digit zero-padded) of the 3 most probable squares.
// https://projecteuler.net/problem=84
import java.util.*;

public final class Euler084 {
    private static final int BOARD = 40;
    // Squares (indices):
    private static final int GO = 0, JAIL = 10, G2J = 30;
    private static final int[] CC = {2, 17, 33};
    private static final int[] CH = {7, 22, 36};
    private static final int[] R = {5, 15, 25, 35};
    private static final int[] U = {12, 28};
    private static final int C1 = 11, E3 = 24, H2 = 39, R1 = 5;

    // Dice sides (4 for this problem)
    private static final int D = 4;

    public static void main(String[] args) {
        // Build transition matrix for 120 states: (pos in 0..39, doubles in 0..2)
        final int STATES = BOARD * 3;
        double[][] T = new double[STATES][STATES];

        // Precompute dice outcomes (sum, isDouble) equally likely 1/D^2
        List<int[]> outcomes = new ArrayList<>();
        for (int a = 1; a <= D; a++) for (int b = 1; b <= D; b++) outcomes.add(new int[]{a + b, (a == b) ? 1 : 0});
        double pOutcome = 1.0 / (D * D);

        for (int pos = 0; pos < BOARD; pos++) {
            for (int ds = 0; ds < 3; ds++) {
                int sIdx = stateIndex(pos, ds);
                for (int[] oc : outcomes) {
                    int sum = oc[0]; boolean isDouble = oc[1] == 1;

                    if (isDouble && ds == 2) {
                        // Three doubles -> go directly to jail, reset doubles
                        int tIdx = stateIndex(JAIL, 0);
                        T[sIdx][tIdx] += pOutcome;
                        continue;
                    }

                    int newDs = isDouble ? (ds + 1) : 0;
                    int land = (pos + sum) % BOARD;

                    // Apply square effects; get distribution over final squares
                    Map<Integer, Double> finalDist = resolveSquare(land);
                    for (Map.Entry<Integer, Double> e : finalDist.entrySet()) {
                        int fpos = e.getKey();
                        double p = e.getValue();
                        int tIdx = stateIndex(fpos, newDs);
                        T[sIdx][tIdx] += pOutcome * p;
                    }
                }
            }
        }

        // Power iteration to get stationary distribution
        double[] v = new double[STATES];
        v[stateIndex(GO, 0)] = 1.0; // start at GO; convergence is independent with enough iters
        double[] tmp = new double[STATES];
        for (int iter = 0; iter < 200; iter++) {
            Arrays.fill(tmp, 0.0);
            for (int i = 0; i < STATES; i++) {
                double vi = v[i]; if (vi == 0.0) continue;
                double[] Ti = T[i];
                for (int j = 0; j < STATES; j++) if (Ti[j] != 0.0) tmp[j] += vi * Ti[j];
            }
            double diff = 0.0;
            for (int i = 0; i < STATES; i++) { diff += Math.abs(tmp[i] - v[i]); v[i] = tmp[i]; }
            if (diff < 1e-14) break;
        }

        // Aggregate across doubles-streak to get per-square probabilities
        double[] prob = new double[BOARD];
        for (int pos = 0; pos < BOARD; pos++) {
            double s = 0; for (int ds = 0; ds < 3; ds++) s += v[stateIndex(pos, ds)];
            prob[pos] = s;
        }

        // Find top 3 squares
    Integer[] idx = new Integer[BOARD]; for (int i = 0; i < BOARD; i++) idx[i] = i;
    java.util.Arrays.sort(idx, (x, y) -> Double.compare(prob[y], prob[x]));
    int i0 = idx[0], i1 = idx[1], i2 = idx[2];
    System.out.printf("%02d%02d%02d\n", i0, i1, i2);
    }

    private static int stateIndex(int pos, int ds) { return pos * 3 + ds; }

    private static boolean isIn(int x, int[] arr) { for (int v : arr) if (v == x) return true; return false; }

    private static int nextR(int pos) {
        for (int r : R) if (r > pos) return r; return R[0];
    }

    private static int nextU(int pos) {
        for (int u : U) if (u > pos) return u; return U[0];
    }

    // Returns distribution over final squares from landing on 'pos' (after dice move) following CC/CH/G2J rules
    private static Map<Integer, Double> resolveSquare(int pos) {
        Map<Integer, Double> map = new HashMap<>();
        if (pos == G2J) { map.put(JAIL, 1.0); return map; }
        if (isIn(pos, CC)) {
            // 16 cards: 2 move, 14 stay
            // GO
            map.put(GO, map.getOrDefault(GO, 0.0) + (2.0/16.0) * 0.5);
            // JAIL
            map.put(JAIL, map.getOrDefault(JAIL, 0.0) + (2.0/16.0) * 0.5);
            // The above splits 2/16 equally into two moves; simpler: add directly
            // But clearer: just add 1/16 to GO and 1/16 to JAIL, plus 14/16 staying put.
            map.clear();
            map.put(GO, 1.0/16.0);
            map.put(JAIL, map.getOrDefault(JAIL, 0.0) + 1.0/16.0);
            map.put(pos, map.getOrDefault(pos, 0.0) + 14.0/16.0);
            return map;
        }
        if (isIn(pos, CH)) {
            // 16 cards: 10 move, 6 stay
            // Direct moves (6 cards)
            add(map, GO, 1.0/16.0);
            add(map, JAIL, 1.0/16.0);
            add(map, C1, 1.0/16.0);
            add(map, E3, 1.0/16.0);
            add(map, H2, 1.0/16.0);
            add(map, R1, 1.0/16.0);
            // Next R (2 cards)
            int r = nextR(pos); add(map, r, 1.0/16.0); add(map, r, 1.0/16.0);
            // Next U (1 card)
            add(map, nextU(pos), 1.0/16.0);
            // Go back 3 squares (1 card) -> may chain into CC or G2J
            int back = (pos + BOARD - 3) % BOARD;
            Map<Integer, Double> backDist = resolveBack3(back);
            for (Map.Entry<Integer, Double> e : backDist.entrySet()) add(map, e.getKey(), e.getValue() * (1.0/16.0));
            // 6 non-move cards: stay on CH square
            add(map, pos, 6.0/16.0);
            return map;
        }
        map.put(pos, 1.0);
        return map;
    }

    // Handle only one level of extra processing when back 3 lands on CC or G2J.
    private static Map<Integer, Double> resolveBack3(int pos) {
        Map<Integer, Double> map = new HashMap<>();
        if (pos == G2J) { map.put(JAIL, 1.0); return map; }
        if (isIn(pos, CC)) {
            // CC from back-3: 1/16 GO, 1/16 JAIL, 14/16 stay on that CC square
            add(map, GO, 1.0/16.0);
            add(map, JAIL, 1.0/16.0);
            add(map, pos, 14.0/16.0);
            return map;
        }
        map.put(pos, 1.0);
        return map;
    }

    private static void add(Map<Integer, Double> map, int key, double val) {
        map.put(key, map.getOrDefault(key, 0.0) + val);
    }
}
