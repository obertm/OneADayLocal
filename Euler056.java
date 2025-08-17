// Euler 056: Powerful digit sum
// Considering natural numbers of the form a^b for a, b < 100, what is the maximum digital sum?
// https://projecteuler.net/problem=56
public final class Euler056 {
    public static void main(String[] args) {
        System.out.println(maxDigitalSum());
    }

    static int maxDigitalSum() {
        int bestSum = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                java.math.BigInteger val = powBig(a, b);
                int s = digitSum(val);
                if (s > bestSum) bestSum = s;
            }
        }
        return bestSum;
    }

    private static java.math.BigInteger powBig(int a, int b) {
        java.math.BigInteger base = java.math.BigInteger.valueOf(a);
        java.math.BigInteger res = java.math.BigInteger.ONE;
        for (int i = 0; i < b; i++) res = res.multiply(base);
        return res;
    }

    private static int digitSum(java.math.BigInteger x) {
        String s = x.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';
        return sum;
    }
}
