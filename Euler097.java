// Euler 097: Large non-Mersenne prime
// Find the last ten digits of the prime number 28433 × 2^7830457 + 1.
// https://projecteuler.net/problem=97
public final class Euler097 {
    public static void main(String[] args) {
    long mod = 10_000_000_000L; // 10^10
    long pow = modPow2(7_830_457L, mod); // 2^7830457 mod 1e10
        long val = (28433 * pow + 1) % mod;
        // Print with leading zeros
        String s = Long.toString(val);
        while (s.length() < 10) s = "0" + s;
        System.out.println(s);
    }

    private static long modPow2(long exp, long mod) {
        long base = 2 % mod;
        long res = 1;
        long e = exp;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            e >>= 1;
        }
        return res;
    }
}
