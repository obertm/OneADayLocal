// Euler 087: Prime power triples
// Count numbers below a limit expressible as p^2 + q^3 + r^4 for primes p, q, r.
// Default limit: 50,000,000 (answer: 1,097,343)
public final class Euler087 {
    public static void main(String[] args) {
        int limit = 50_000_000;
        if (args != null && args.length > 0) {
            try { limit = Integer.parseInt(args[0]); } catch (Exception ignore) {}
        }

        java.util.List<Integer> primes = sievePrimes((int) Math.sqrt(limit) + 5);

        // Precompute prime powers under limit
        java.util.ArrayList<Integer> squares = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> cubes = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> fourths = new java.util.ArrayList<>();

        for (int p : primes) {
            long p2 = (long) p * p;
            if (p2 < limit) squares.add((int) p2);
            else break;
        }

        // For cubes and fourths, we only need primes up to cbrt(limit) and 4th-root(limit)
        int maxCubePrime = (int) Math.cbrt(limit) + 1;
        int maxFourthPrime = (int) Math.sqrt(Math.sqrt(limit)) + 1;
        for (int p : primes) {
            if (p <= maxCubePrime) {
                long p3 = (long) p * p * p;
                if (p3 < limit) cubes.add((int) p3);
            }
            if (p <= maxFourthPrime) {
                long p4 = (long) p * p * p * p;
                if (p4 < limit) fourths.add((int) p4);
            }
        }

        java.util.BitSet seen = new java.util.BitSet(limit);

        // Triple nested with early breaks (arrays are increasing)
        for (int a : squares) {
            for (int b : cubes) {
                long ab = (long) a + b;
                if (ab >= limit) break;
                for (int c : fourths) {
                    long s = ab + c;
                    if (s >= limit) break;
                    seen.set((int) s);
                }
            }
        }

        System.out.println(seen.cardinality());
    }

    private static java.util.List<Integer> sievePrimes(int n) {
        boolean[] comp = new boolean[n + 1];
        java.util.ArrayList<Integer> primes = new java.util.ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (!comp[i]) {
                for (int j = i * i; j <= n; j += i) comp[j] = true;
            }
        }
        for (int i = 2; i <= n; i++) if (!comp[i]) primes.add(i);
        return primes;
    }
}
