// Euler 097: Large non-Mersenne prime
// Find the last ten digits of the prime number 28433 × 2^7830457 + 1.
// https://projecteuler.net/problem=97
public final class Euler097 {
    public static void main(String[] args) {
        java.math.BigInteger mod = java.math.BigInteger.TEN.pow(10); // 10^10
        java.math.BigInteger pow = modPow2BI(7_830_457L, mod); // 2^7830457 mod 1e10
        java.math.BigInteger val = java.math.BigInteger.valueOf(28433).multiply(pow).add(java.math.BigInteger.ONE).mod(mod);
        String s = val.toString();
        while (s.length() < 10) s = "0" + s;
        System.out.println(s);
    }

    private static java.math.BigInteger modPow2BI(long exp, java.math.BigInteger mod) {
        java.math.BigInteger base = java.math.BigInteger.valueOf(2).mod(mod);
        java.math.BigInteger res = java.math.BigInteger.ONE;
        long e = exp;
        while (e > 0) {
            if ((e & 1) == 1) res = res.multiply(base).mod(mod);
            base = base.multiply(base).mod(mod);
            e >>= 1;
        }
        return res;
    }
}
