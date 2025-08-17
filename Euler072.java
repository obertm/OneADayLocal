// Euler 072: Counting fractions
// How many reduced proper fractions are there for d ≤ 1,000,000?
// https://projecteuler.net/problem=72
public final class Euler072 {
    public static void main(String[] args) {
        int limit = 1_000_000;
        long[] phi = new long[limit + 1];
        for (int i = 0; i <= limit; i++) phi[i] = i;
        for (int p = 2; p <= limit; p++) {
            if (phi[p] == p) { // prime
                for (int k = p; k <= limit; k += p) phi[k] -= phi[k] / p;
            }
        }
        long sum = 0;
        for (int d = 2; d <= limit; d++) sum += phi[d];
        System.out.println(sum);
    }
}
