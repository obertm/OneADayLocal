// Euler 086: Cuboid route
// Find the least value of M such that the number of integer shortest path solutions across an M×M×M cuboid first exceeds a threshold (default 1,000,000).
// https://projecteuler.net/problem=86
public final class Euler086 {
    public static void main(String[] args) {
        long target = 1_000_000L;
        if (args != null && args.length > 0) {
            try { target = Long.parseLong(args[0]); } catch (Exception ignore) {}
        }

        long count = 0;
        int M = 0;
        while (count <= target) {
            M++;
            // For this M, consider all s = a + b with 1 <= a <= b <= M, so s in [2 .. 2M].
            // The shortest path across the a x b face has length sqrt(s^2 + M^2).
            // It's integer when s^2 + M^2 is a perfect square.
            for (int s = 2; s <= 2 * M; s++) {
                long v = (long) s * s + (long) M * M;
                int r = (int) Math.sqrt(v);
                if ((long) r * r == v) {
                    // Count how many (a,b) with a <= b <= M and a + b = s
                    // If s <= M: a ranges 1..floor(s/2) -> floor(s/2) pairs
                    // Else: a ranges from (s - M) .. floor(s/2) -> floor(s/2) - (s - M) + 1 = 1 + M - ceil(s/2)
                    if (s <= M) {
                        count += s / 2; // floor(s/2)
                    } else {
                        count += 1 + M - ((s + 1) / 2); // 1 + M - ceil(s/2)
                    }
                }
            }
        }
        System.out.println(M);
    }
}
