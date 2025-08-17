// Euler 035: Circular primes
public final class Euler035 {
    private static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        java.util.Arrays.fill(isPrime, true);
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;
        for (int p = 2; p * p <= n; p++) if (isPrime[p]) for (int q = p * p; q <= n; q += p) isPrime[q] = false;
        return isPrime;
    }

    private static boolean isCircularPrime(int x, boolean[] isPrime) {
        String s = Integer.toString(x);
        // Early prune: if any digit even or 5 (except single-digit) then cannot be circular prime
        if (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0' || c == '2' || c == '4' || c == '5' || c == '6' || c == '8') return false;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int v = Integer.parseInt(s.substring(i) + s.substring(0, i));
            if (v >= isPrime.length || !isPrime[v]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int limit = args.length > 0 ? Integer.parseInt(args[0]) : 1_000_000;
        boolean[] isPrime = sieve(limit);
        int count = 0;
        for (int i = 2; i < limit; i++) if (isCircularPrime(i, isPrime)) count++;
        System.out.println(count);
    }
}
