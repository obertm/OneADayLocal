// Euler 075: Singular integer right triangles
// Given perimeters up to 1,500,000, how many values of p can form exactly one integer right triangle?
// https://projecteuler.net/problem=75
public final class Euler075 {
    public static void main(String[] args) {
        final int LIMIT = 1_500_000;
        int[] count = new int[LIMIT + 1];
        int result = 0;
        for (int m = 2; 2*m*m < LIMIT; m++) {
            for (int n = 1; n < m; n++) {
                if (((m - n) & 1) == 0) continue; // opposite parity
                if (gcd(m, n) != 1) continue;     // coprime
                int p0 = 2 * m * (m + n);
                if (p0 > LIMIT) break;
                for (int k = 1; k * p0 <= LIMIT; k++) {
                    int p = k * p0;
                    if (++count[p] == 1) result++;
                    else if (count[p] == 2) result--; // no longer singular
                }
            }
        }
        System.out.println(result);
    }

    private static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
}
