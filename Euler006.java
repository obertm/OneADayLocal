// Euler 006: Sum square difference
public final class Euler006 {
    // sum_{i=1..n} i = n(n+1)/2
    private static long sumFirstN(long n) {
        return n * (n + 1) / 2;
    }

    // sum_{i=1..n} i^2 = n(n+1)(2n+1)/6
    private static long sumSquaresFirstN(long n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }

    public static long difference(long n) {
        long s = sumFirstN(n);
        long ss = sumSquaresFirstN(n);
        return s * s - ss;
    }

    public static void main(String[] args) {
        long n = 100;
        if (args.length > 0) {
            n = Long.parseLong(args[0]);
        }
        System.out.println(difference(n));
    }
}
