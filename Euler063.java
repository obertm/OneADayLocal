// Euler 063: Powerful digit counts
// How many n-digit positive integers exist which are also an nth power?
// https://projecteuler.net/problem=63
public final class Euler063 {
    public static void main(String[] args) {
        System.out.println(count());
    }

    static int count() {
        int total = 0;
        for (int a = 1; a < 10; a++) { // base 1..9 (10^n has n+1 digits)
            java.math.BigInteger base = java.math.BigInteger.valueOf(a);
            java.math.BigInteger val = java.math.BigInteger.ONE; // a^0
            for (int n = 1; ; n++) {
                val = val.multiply(base);
                int digits = val.toString().length();
                if (digits == n) total++; else if (digits < n) break; // for base 1..9, digits grows slower than n
            }
        }
        return total;
    }
}
