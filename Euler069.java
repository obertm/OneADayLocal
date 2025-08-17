// Euler 069: Totient maximum
// Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
// https://projecteuler.net/problem=69
public final class Euler069 {
    public static void main(String[] args) {
        int limit = 1_000_000;
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
        long n = 1;
        for (int p : primes) {
            if (n * p > limit) break;
            n *= p;
        }
        System.out.println(n);
    }
}
