// Euler 007: 10001st prime
import java.util.*;

public final class Euler007 {
    private static boolean isPrime(long x, ArrayList<Integer> primes) {
        if (x < 2) return false;
        long limit = (long) Math.sqrt(x);
        for (int p : primes) {
            if (p > limit) break;
            if (x % p == 0) return false;
        }
        return true;
    }

    public static int nthPrime(int n) {
        if (n < 1) throw new IllegalArgumentException("n must be >= 1");
        ArrayList<Integer> primes = new ArrayList<>();
        int candidate = 2;
        while (primes.size() < n) {
            if (isPrime(candidate, primes)) {
                primes.add(candidate);
            }
            candidate += (candidate == 2) ? 1 : 2; // skip even numbers after 2
        }
        return primes.get(primes.size() - 1);
    }

    public static void main(String[] args) {
        int n = 10001;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }
        System.out.println(nthPrime(n));
    }
}
