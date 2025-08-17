// Euler 073: Counting fractions in a range
// How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?
// https://projecteuler.net/problem=73
public final class Euler073 {
    public static void main(String[] args) {
        final int N = 12_000;
        // Count reduced fractions in (1/3, 1/2] with denominator <= N using Farey sequence stepping.
        // Initialize with neighbors in Stern-Brocot tree: 1/3 and 1/2 (bc - ad = 1)
        int a = 1, b = 3;
        int c = 1, d = 2;
        long count = 0;
        while (true) {
            int k = (N + b) / d;
            int e = k * c - a;
            int f = k * d - b;
            if (e == 1 && f == 2) break; // reached upper bound; don't include 1/2
            a = c; b = d; c = e; d = f;
            count++;
        }
        System.out.println(count);
    }
}
