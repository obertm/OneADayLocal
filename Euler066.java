// Euler 066: Diophantine equation
// Find the value of D ≤ 1000 in minimal solutions of x^2 − Dy^2 = 1 for which the largest value of x is obtained.
// https://projecteuler.net/problem=66
public final class Euler066 {
    private static boolean isSquare(int n) { int r = (int) Math.round(Math.sqrt(n)); return r * r == n; }

    private static java.math.BigInteger[] minimalSolutionPell(int D) {
        // Continued fraction expansion for sqrt(D)
        int a0 = (int) Math.sqrt(D);
        int m = 0, d = 1, a = a0;
        java.math.BigInteger num1 = java.math.BigInteger.ONE; // p_{-1}
        java.math.BigInteger num = java.math.BigInteger.valueOf(a0); // p_0
        java.math.BigInteger den1 = java.math.BigInteger.ZERO; // q_{-1}
        java.math.BigInteger den = java.math.BigInteger.ONE; // q_0
        // iterate until p^2 - D q^2 = 1
        while (true) {
            java.math.BigInteger lhs = num.multiply(num).subtract(java.math.BigInteger.valueOf(D).multiply(den).multiply(den));
            if (java.math.BigInteger.ONE.equals(lhs)) return new java.math.BigInteger[]{num, den};
            m = d * a - m;
            d = (D - m * m) / d;
            a = (a0 + m) / d;
            // next convergent
            java.math.BigInteger numNext = num.multiply(java.math.BigInteger.valueOf(a)).add(num1);
            java.math.BigInteger denNext = den.multiply(java.math.BigInteger.valueOf(a)).add(den1);
            num1 = num; num = numNext; den1 = den; den = denNext;
        }
    }

    public static void main(String[] args) {
        java.math.BigInteger bestX = java.math.BigInteger.ZERO;
        int bestD = 0;
        for (int D = 2; D <= 1000; D++) {
            if (isSquare(D)) continue;
            java.math.BigInteger[] sol = minimalSolutionPell(D);
            if (sol[0].compareTo(bestX) > 0) { bestX = sol[0]; bestD = D; }
        }
        System.out.println(bestD);
    }
}
