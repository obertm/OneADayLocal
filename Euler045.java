// Euler 045: Triangular, pentagonal, and hexagonal
public final class Euler045 {
    private static long tri(long n) { return n * (n + 1) / 2; }
    private static boolean isPent(long x) { double n = (1 + Math.sqrt(1 + 24.0 * x)) / 6.0; return Math.abs(n - Math.round(n)) < 1e-12; }
    private static boolean isHex(long x) { double n = (1 + Math.sqrt(1 + 8.0 * x)) / 4.0; return Math.abs(n - Math.round(n)) < 1e-12; }

    public static void main(String[] args) {
        for (long n = 286; ; n++) {
            long t = tri(n);
            if (isPent(t) && isHex(t)) { System.out.println(t); return; }
        }
    }
}
