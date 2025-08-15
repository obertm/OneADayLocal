public final class Euler002 {
    public static long sumEvenFib(int limit) {
        long a = 1, b = 2, sum = 0;
        while (b <= limit) {
            if ((b & 1) == 0) sum += b;
            long next = a + b;
            a = b;
            b = next;
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