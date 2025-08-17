// Euler 080: Square root digital expansion
// Find the total of the digital sums of the first one hundred decimal digits for the irrational square roots of the first one hundred natural numbers.
// https://projecteuler.net/problem=80
public final class Euler080 {
    public static void main(String[] args) {
        int total = 0;
        for (int n = 1; n <= 100; n++) {
            int r = (int)Math.sqrt(n);
            if (r * r == n) continue; // skip perfect squares
            java.math.BigInteger bi = java.math.BigInteger.valueOf(n);
            java.math.BigInteger scale = java.math.BigInteger.TEN.pow(200); // 10^(2*100)
            java.math.BigInteger N = bi.multiply(scale);
            java.math.BigInteger s = isqrt(N);
            String digits = s.toString();
            // Sum all digits of s (integer part + 100 decimal digits)
            int sum = 0; for (int i = 0; i < digits.length(); i++) sum += digits.charAt(i) - '0';
            total += sum;
        }
        System.out.println(total);
    }

    // Integer square root for BigInteger: floor(sqrt(x))
    private static java.math.BigInteger isqrt(java.math.BigInteger x) {
        java.math.BigInteger zero = java.math.BigInteger.ZERO;
        java.math.BigInteger one = java.math.BigInteger.ONE;
        java.math.BigInteger two = java.math.BigInteger.valueOf(2);
        if (x.signum() <= 0) return zero;
        // Initial guess: 1 << ((bitLength+1)/2)
        int bl = x.bitLength();
        java.math.BigInteger g = one.shiftLeft((bl + 1) / 2);
        while (true) {
            java.math.BigInteger ng = g.add(x.divide(g)).divide(two);
            if (ng.equals(g) || ng.equals(g.subtract(one))) {
                // Ensure ng^2 <= x
                while (ng.multiply(ng).compareTo(x) > 0) ng = ng.subtract(one);
                return ng;
            }
            g = ng;
        }
    }
}
