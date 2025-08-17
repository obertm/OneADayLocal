// Euler 048: Self powers
public final class Euler048 {
    public static void main(String[] args) {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
        java.math.BigInteger mod = java.math.BigInteger.valueOf(10_000_000_000L);
        java.math.BigInteger sum = java.math.BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            java.math.BigInteger b = java.math.BigInteger.valueOf(i);
            sum = sum.add(b.modPow(b, mod)).mod(mod);
        }
        System.out.println(sum.longValue());
    }
}
