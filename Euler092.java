// Euler 092: Square digit chains
// How many starting numbers below ten million will arrive at 89 during the square digit chain process?
// https://projecteuler.net/problem=92
public final class Euler092 {
    public static void main(String[] args) {
        int limit = 10_000_000; // below ten million
        if (args != null && args.length > 0) { try { limit = Integer.parseInt(args[0]); } catch (Exception ignore) {} }
        int maxSum = 7 * 81; // max sum of squares for <10^7
        byte[] memo = new byte[maxSum + 1]; // 0 unknown, 1 -> ends at 1, 2 -> ends at 89
        memo[1] = 1; memo[89] = 2;
        int count = 0;
        for (int n = 1; n < limit; n++) {
            int x = n;
            java.util.ArrayList<Integer> path = null;
            while (true) {
                int s = 0, t = x;
                while (t > 0) { int d = t % 10; s += d * d; t /= 10; }
                x = s;
                if (x <= maxSum && memo[x] != 0) {
                    byte end = memo[x];
                    if (end == 2) count++;
                    if (path != null) {
                        for (int v : path) if (v <= maxSum) memo[v] = end;
                    }
                    break;
                }
                if (path == null) path = new java.util.ArrayList<>();
                path.add(x);
            }
        }
        System.out.println(count);
    }
}
