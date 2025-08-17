// Euler 051: Prime digit replacements
// Find the smallest prime which, by replacing part of the number with the same digit, is part of an eight-prime family.
// https://projecteuler.net/problem=51
public final class Euler051 {
    public static void main(String[] args) {
        System.out.println(findSmallestPrimeInEightFamily());
    }

    static int findSmallestPrimeInEightFamily() {
        final int LIMIT = 2_000_000; // generous upper bound; known solution is well below this
        boolean[] isPrime = sieve(LIMIT);
        for (int p = 11; p < LIMIT; p += 2) { // start from first 2-digit odd prime
            if (!isPrime[p]) continue;
            char[] digits = Integer.toString(p).toCharArray();
            int L = digits.length;
            // For each non-empty mask over digit positions
            int maxMask = (1 << L) - 1;
            for (int mask = 1; mask <= maxMask; mask++) {
                // All masked positions must share the same digit in the source number
                int firstIdx = Integer.numberOfTrailingZeros(mask);
                char target = digits[firstIdx];
                boolean same = true;
                for (int i = firstIdx + 1; i < L; i++) {
                    if (((mask >> i) & 1) == 1 && digits[i] != target) { same = false; break; }
                }
                if (!same) continue;

                int count = 0;
                int minPrime = Integer.MAX_VALUE;
                // Try replacing masked positions by each digit 0..9
                for (char rep = '0'; rep <= '9'; rep++) {
                    // Leading zero not allowed
                    if (((mask & 1) == 1) && rep == '0') continue;
                    // Build the candidate number
                    int val = 0;
                    for (int i = 0; i < L; i++) {
                        char ch = (((mask >> i) & 1) == 1) ? rep : digits[i];
                        val = val * 10 + (ch - '0');
                    }
                    if (val >= LIMIT) continue; // out of sieve bounds
                    if (isPrime[val]) {
                        count++;
                        if (val < minPrime) minPrime = val;
                    }
                }
                if (count >= 8) {
                    return minPrime;
                }
            }
        }
        throw new IllegalStateException("Not found within limit");
    }

    private static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        if (n >= 2) {
            java.util.Arrays.fill(prime, true);
            prime[0] = prime[1] = false;
            int r = (int) Math.sqrt(n);
            for (int i = 2; i <= r; i++) {
                if (prime[i]) {
                    for (int j = i * i; j <= n; j += i) prime[j] = false;
                }
            }
        }
        return prime;
    }
}
