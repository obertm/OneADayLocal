// Euler 012: Highly divisible triangular number
public final class Euler012 {
    private static int countDivisors(long n) {
        if (n == 1) return 1;
        int total = 1;
        int exp = 0;
        while ((n & 1L) == 0) { n >>= 1; exp++; }
        if (exp > 0) total *= (exp + 1);
        for (long p = 3; p * p <= n; p += 2) {
            exp = 0;
            while (n % p == 0) { n /= p; exp++; }
            if (exp > 0) total *= (exp + 1);
        }
        if (n > 1) total *= 2;
        return total;
    }

    public static long firstTriangleOverDivisors(int threshold) {
        // T_n = n(n+1)/2; since gcd(n, n+1) = 1, factor (n/2) and (n+1) or n and ((n+1)/2)
        for (int n = 1; ; n++) {
            long a, b;
            if ((n & 1) == 0) { // n even
                a = n / 2;
                b = (long)n + 1;
            } else { // n odd
                a = n;
                b = ((long)n + 1) / 2;
            }
            int divisors = countDivisors(a) * countDivisors(b);
            if (divisors > threshold) {
                return a * b;
            }
        }
    }

    public static void main(String[] args) {
        int threshold = 500;
        if (args != null && args.length > 0) {
            try { threshold = Integer.parseInt(args[0]); } catch (Exception ignored) {}
        }
        System.out.println(firstTriangleOverDivisors(threshold));
    }
}
