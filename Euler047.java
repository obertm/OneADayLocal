// Euler 047: Distinct primes factors
public final class Euler047 {
    private static int countDistinctPrimeFactors(int n) {
        int count = 0; int m = n;
        for (int p = 2; p * p <= m; p++) {
            if (m % p == 0) {
                count++;
                while (m % p == 0) m /= p;
            }
        }
        if (m > 1) count++;
        return count;
    }

    public static void main(String[] args) {
        int k = args.length > 0 ? Integer.parseInt(args[0]) : 4;
        int n = 2, streak = 0;
        while (true) {
            if (countDistinctPrimeFactors(n) == k) {
                streak++;
                if (streak == k) { System.out.println(n - k + 1); return; }
            } else streak = 0;
            n++;
        }
    }
}
