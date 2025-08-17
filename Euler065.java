// Euler 065: Convergents of e
// Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
// https://projecteuler.net/problem=65
public final class Euler065 {
    public static void main(String[] args) {
        System.out.println(sumDigitsNumerator100th());
    }

    static int sumDigitsNumerator100th() {
        // Continued fraction for e: [2; 1,2,1, 1,4,1, 1,6,1, ...]
        int N = 100;
        int[] a = new int[N];
        a[0] = 2;
        for (int k = 1; k < N; k++) {
            if ((k % 3) == 2) a[k] = 2 * ((k + 1) / 3);
            else a[k] = 1;
        }
        java.math.BigInteger num = java.math.BigInteger.ONE;
        java.math.BigInteger den = java.math.BigInteger.ZERO;
        for (int i = N - 1; i >= 0; i--) {
            // num/den = a[i] + 1/(num/den) => swap then add
            java.math.BigInteger tmp = num;
            num = num.multiply(java.math.BigInteger.valueOf(a[i])).add(den);
            den = tmp;
        }
        // num/den is the fraction; sum digits of numerator
        String s = num.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';
        return sum;
    }
}
