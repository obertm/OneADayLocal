// Euler 064: Odd period square roots
// How many continued fractions for sqrt(N) with N ≤ 10000 have an odd period?
// https://projecteuler.net/problem=64
public final class Euler064 {
    private static int period(int n) {
        int a0 = (int) Math.floor(Math.sqrt(n));
        if (a0 * a0 == n) return 0; // perfect square
        int m = 0;
        int d = 1;
        int a = a0;
        int p = 0;
        do {
            m = d * a - m;
            d = (n - m * m) / d;
            a = (a0 + m) / d;
            p++;
        } while (a != 2 * a0);
        return p;
    }

    public static void main(String[] args) {
        int limit = 10_000;
        if (args != null && args.length > 0) {
            try { limit = Integer.parseInt(args[0]); } catch (Exception ignored) {}
        }
        int count = 0;
        for (int n = 2; n <= limit; n++) if ((period(n) & 1) == 1) count++;
        System.out.println(count);
    }
}
