// Euler 026: Reciprocal cycles
// Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
public final class Euler026 {
    private static int cycleLength(int d) {
        // Remove factors of 2 and 5 since they don't contribute to repeating part
        while (d % 2 == 0) d /= 2;
        while (d % 5 == 0) d /= 5;
        if (d == 1) return 0; // terminates
        // Find multiplicative order of 10 mod d
        int len = 1;
        int mod = 10 % d;
        while (mod != 1) {
            mod = (mod * 10) % d;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int limit = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
        int bestD = 0, bestLen = -1;
        for (int d = 2; d < limit; d++) {
            int len = cycleLength(d);
            if (len > bestLen) {
                bestLen = len;
                bestD = d;
            }
        }
        System.out.println(bestD);
    }
}
