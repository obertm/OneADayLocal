// Euler 057: Square root convergents
// In the first one-thousand expansions of sqrt(2), how many fractions contain a numerator with more digits than the denominator?
// https://projecteuler.net/problem=57
public final class Euler057 {
    public static void main(String[] args) {
        System.out.println(countExpansionsWithLongerNumerator());
    }

    static int countExpansionsWithLongerNumerator() {
        // Iteratively compute convergents of sqrt(2): start with 3/2, then next = 1 + 1/(1 + prev)
        java.math.BigInteger num = java.math.BigInteger.valueOf(3);
        java.math.BigInteger den = java.math.BigInteger.valueOf(2);
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (num.toString().length() > den.toString().length()) count++;
            // Next expansion: (num, den) <- (num+2*den, num+den)
            java.math.BigInteger newNum = num.add(den.shiftLeft(1));
            java.math.BigInteger newDen = num.add(den);
            num = newNum;
            den = newDen;
        }
        return count;
    }
}
