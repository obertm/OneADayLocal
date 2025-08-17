// Euler 076: Counting summations
// How many different ways can one hundred be written as a sum of at least two positive integers?
// https://projecteuler.net/problem=76
public final class Euler076 {
    public static void main(String[] args) {
        int N = 100;
        long[] ways = new long[N + 1];
        ways[0] = 1;
        for (int coin = 1; coin <= N; coin++) {
            for (int s = coin; s <= N; s++) {
                ways[s] += ways[s - coin];
            }
        }
        // Exclude the single term 100 itself
        System.out.println(ways[N] - 1);
    }
}
