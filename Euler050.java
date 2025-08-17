// Euler 050: Consecutive prime sum
public final class Euler050 {
    private static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        java.util.Arrays.fill(isPrime, true);
        if (n >= 0) isPrime[0] = false; if (n >= 1) isPrime[1] = false;
        for (int p = 2; p * p <= n; p++) if (isPrime[p]) for (int q = p * p; q <= n; q += p) isPrime[q] = false;
        return isPrime;
    }

    public static void main(String[] args) {
        int limit = args.length > 0 ? Integer.parseInt(args[0]) : 1_000_000;
        boolean[] isPrime = sieve(limit);
        java.util.ArrayList<Integer> primes = new java.util.ArrayList<>();
        for (int i = 2; i < limit; i++) if (isPrime[i]) primes.add(i);
        long[] prefix = new long[primes.size() + 1];
        for (int i = 0; i < primes.size(); i++) prefix[i + 1] = prefix[i] + primes.get(i);
        int bestLen = 0, bestPrime = 0;
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + bestLen + 1; j <= primes.size(); j++) { // only longer sequences
                long sum = prefix[j] - prefix[i];
                if (sum >= limit) break;
                if (isPrime[(int) sum]) { bestLen = j - i; bestPrime = (int) sum; }
            }
        }
        System.out.println(bestPrime);
    }
}
