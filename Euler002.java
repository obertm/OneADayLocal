public final class Euler002 {
    public static long sumEvenFib(int limit) {
        // Iterate only even Fibonacci terms: 2, 8, 34, ... with E(n) = 4*E(n-1) + E(n-2)
        if (limit < 2) return 0L;
        long e1 = 2L;  // E1
        long e2 = 8L;  // E2
        long sum = 0L;
        while (e1 <= limit) {
            sum += e1;
            long e3 = 4L * e2 + e1;
            e1 = e2;
            e2 = e3;
        }
        return sum;
    }

    public static void main(String[] args) {
        int limit = 4_000_000;
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
        System.out.println(sumEvenFib(limit));
    }
}