// Euler 033: Digit cancelling fractions
public final class Euler033 {
    private static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    public static void main(String[] args) {
        int num = 1, den = 1;
        for (int a = 10; a < 100; a++) {
            for (int b = a + 1; b < 100; b++) {
                int a1 = a / 10, a2 = a % 10;
                int b1 = b / 10, b2 = b % 10;
                if (a2 == 0 && b2 == 0) continue; // trivial
                // four cancel possibilities
                if (a2 == b1 && b2 != 0 && a * 1.0 / b == (a1 * 1.0 / b2)) { num *= a1; den *= b2; }
                else if (a1 == b2 && b1 != 0 && a * 1.0 / b == (a2 * 1.0 / b1)) { num *= a2; den *= b1; }
                else if (a1 == b1 && b2 != 0 && a * 1.0 / b == (a2 * 1.0 / b2)) { num *= a2; den *= b2; }
                else if (a2 == b2 && b1 != 0 && a * 1.0 / b == (a1 * 1.0 / b1)) { num *= a1; den *= b1; }
            }
        }
        int g = gcd(num, den);
        System.out.println(den / g);
    }
}
