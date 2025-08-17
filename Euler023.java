// Euler 023: Non-abundant sums
// Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
public final class Euler023 {
    private static int sumProperDivisors(int n) {
        if (n <= 1) return 0;
        int sum = 1;
        int m = n;
        for (int p = 2; p * p <= m; p++) {
            if (m % p == 0) {
                int term = 1;
                int acc = 1;
                while (m % p == 0) {
                    m /= p;
                    acc *= p;
                    term += acc;
                }
                sum *= term;
            }
        }
        if (m > 1) sum *= (1 + m);
        return sum - n;
    }

    public static void main(String[] args) {
        final int LIMIT = 28123;
        boolean[] abundant = new boolean[LIMIT + 1];
        java.util.ArrayList<Integer> abundants = new java.util.ArrayList<>();
        for (int i = 1; i <= LIMIT; i++) {
            if (sumProperDivisors(i) > i) {
                abundant[i] = true;
                abundants.add(i);
            }
        }

        boolean[] can = new boolean[LIMIT + 1];
        for (int i = 0; i < abundants.size(); i++) {
            int a = abundants.get(i);
            for (int j = i; j < abundants.size(); j++) {
                int b = abundants.get(j);
                int s = a + b;
                if (s > LIMIT) break;
                can[s] = true;
            }
        }
        long total = 0L;
        for (int i = 1; i <= LIMIT; i++) if (!can[i]) total += i;
        System.out.println(total);
    }
}
