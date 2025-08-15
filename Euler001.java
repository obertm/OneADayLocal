public final class Euler001 {
    // Sum of multiples of 3 or 5 below N
    public static long sumMultiples3or5Below(int n) {
        long sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int limit = 1000;
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
        System.out.println(sumMultiples3or5Below(limit));
    }
}
