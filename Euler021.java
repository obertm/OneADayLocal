// Euler 021: Amicable numbers
public final class Euler021 {
    private static int sumProperDivisors(int n) {
        if (n <= 1) return 0;
        int sum = 1; // 1 is a proper divisor for n>1
        int m = n;
        int p = 2;
        while (p * p <= m) {
            if (m % p == 0) {
                int term = 1;
                int pow = 1;
                while (m % p == 0) {
                    m /= p;
                    pow *= p;
                    term += pow;
                }
                sum *= term;
            }
            p = (p == 2) ? 3 : p + 2; // check 2 then odds
        }
        if (m > 1) sum *= (1 + m);
        return sum - n; // convert sigma(n) to sum of proper divisors
    }

    public static int sumAmicableBelow(int limit) {
        int[] d = new int[limit];
        for (int i = 1; i < limit; i++) d[i] = sumProperDivisors(i);
        int sum = 0;
        for (int a = 2; a < limit; a++) {
            int b = d[a];
            if (b != a && b < limit && b > 0 && d[b] == a) {
                sum += a;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int limit = 10_000;
        if (args != null && args.length > 0) {
            try { limit = Integer.parseInt(args[0]); } catch (Exception ignored) {}
        }
        System.out.println(sumAmicableBelow(limit));
    }
}
