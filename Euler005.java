public final class Euler005 {
    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static long lcmUpTo(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = lcm(ans, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 20;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }
        System.out.println(lcmUpTo(n));
    }
}
