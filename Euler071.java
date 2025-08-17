// Euler 071: Ordered fractions
// Consider the fraction 3/7. Find the fraction immediately to the left of 3/7 in the sorted set of reduced proper fractions for d ≤ 1,000,000.
// https://projecteuler.net/problem=71
public final class Euler071 {
    public static void main(String[] args) {
        int limit = 1_000_000;
        long bestNum = 0, bestDen = 1;
        for (int d = 2; d <= limit; d++) {
            long n = (3L * d - 1) / 7; // floor just below 3/7
            if (n * bestDen > bestNum * d) { bestNum = n; bestDen = d; }
        }
        System.out.println(bestNum); // project asks for numerator only
    }
}
