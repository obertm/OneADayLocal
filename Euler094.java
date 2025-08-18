// Euler 094: Almost equilateral triangles
// Find the sum of the perimeters of all almost equilateral triangles with integer side lengths and integer area, with perimeter ≤ 1,000,000,000.
// https://projecteuler.net/problem=94
public final class Euler094 {
    public static void main(String[] args) {
        final long LIMIT = 1_000_000_000L;
        // Reduce to Pell-type x^2 - 3y^2 = 4 with x = 3a ± 1, y = 2h
        // Generate all positive solutions by multiplying by (2+√3)^n:
        // (x', y') = (2x + 3y, x + 2y)
        long sum = 0L;

        long x = 14; // corresponds to a = 5 (a+1 case), p = 16
        long y = 8;
        while (true) {
            long p;
            if (x % 3 == 2) {
                // a+1 case (x = 3a - 1) -> p = 3a + 1 = x + 2
                p = x + 2;
            } else if (x % 3 == 1) {
                // a-1 case (x = 3a + 1) -> p = 3a - 1 = x - 2
                p = x - 2;
            } else {
                // Not expected for positive solutions we encounter, but guard anyway
                p = Long.MAX_VALUE;
            }

            if (p > LIMIT) break;
            sum += p;

            long nx = 2 * x + 3 * y;
            long ny = x + 2 * y;
            x = nx; y = ny;
        }

        System.out.println(sum);
    }
}
