// Euler 080: Square root digital expansion
// Find the total of the digital sums of the first one hundred decimal digits for the irrational square roots of the first one hundred natural numbers.
// https://projecteuler.net/problem=80
public final class Euler080 {
    public static void main(String[] args) {
        int total = 0;
        for (int n = 1; n <= 100; n++) {
            int r = (int)Math.sqrt(n);
            if (r * r == n) continue; // skip perfect squares
            total += digitSumFirst100Digits(n);
        }
        System.out.println(total);
    }

    // Canonical longhand digit extraction: produce first 100 digits (integer part + 99 fractional)
    // of sqrt(n) and return their digit sum. This matches Project Euler problem wording
    // which counts the integer part as the first digit.
    private static int digitSumFirst100Digits(int n) {
        // Prepare pairs for integer part
        String s = Integer.toString(n);
        if ((s.length() & 1) == 1) s = "0" + s; // ensure even length
        int pairIndex = 0;
        java.math.BigInteger rem = java.math.BigInteger.ZERO;
        java.math.BigInteger root = java.math.BigInteger.ZERO;
        int sum = 0;
        for (int produced = 0; produced < 100; produced++) {
            int pair;
            if (pairIndex < s.length()) {
                pair = Integer.parseInt(s.substring(pairIndex, pairIndex + 2));
                pairIndex += 2;
            } else {
                pair = 0; // fractional extension adds "00"
            }
            rem = rem.multiply(java.math.BigInteger.valueOf(100)).add(java.math.BigInteger.valueOf(pair));
            java.math.BigInteger base = root.multiply(java.math.BigInteger.valueOf(20));
            int x = 0;
            // Ascending search (digits small so loop is fine)
            while (x < 9) {
                java.math.BigInteger test = base.add(java.math.BigInteger.valueOf(x + 1)).multiply(java.math.BigInteger.valueOf(x + 1));
                if (test.compareTo(rem) > 0) break;
                x++;
            }
            java.math.BigInteger sub = base.add(java.math.BigInteger.valueOf(x)).multiply(java.math.BigInteger.valueOf(x));
            rem = rem.subtract(sub);
            root = root.multiply(java.math.BigInteger.TEN).add(java.math.BigInteger.valueOf(x));
            sum += x;
        }
        return sum;
    }
}
