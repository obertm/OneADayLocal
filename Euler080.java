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
            // Sum only the first 100 decimal digits: the last 100 digits of s
            int sum = 0;
            int L = digits.length();
            for (int i = Math.max(0, L - 100); i < L; i++) sum += digits.charAt(i) - '0';
            total += sum;
        }
        System.out.println(total);
    }

    // Integer square root for BigInteger: floor(sqrt(x)) via binary search (robust)
    private static java.math.BigInteger isqrt(java.math.BigInteger x) {
        if (x.signum() <= 0) return java.math.BigInteger.ZERO;
        java.math.BigInteger one = java.math.BigInteger.ONE;
        int bl = x.bitLength();
        java.math.BigInteger high = one.shiftLeft((bl + 1) / 2 + 1); // safe upper bound
        java.math.BigInteger low = java.math.BigInteger.ZERO;
        while (high.compareTo(low) > 0) {
            java.math.BigInteger mid = low.add(high).add(one).shiftRight(1);
            if (mid.multiply(mid).compareTo(x) <= 0) {
                low = mid;
            } else {
                high = mid.subtract(one);
            }
        }
        return low;
    }
}
