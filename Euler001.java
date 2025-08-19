public final class Euler001 {
    // Sum of multiples of 3 or 5 below N
    // Backward-compatible: sum of multiples of 3 or 5 below n (Euler #1)
    public static long sumMultiples3or5Below(int n) {
        return sumOfMultiplesBelow(n, 3, 5);
    }

    // Generalized: sum of multiples of any positive divisors below n using inclusion–exclusion
    public static long sumOfMultiplesBelow(int n, int... divisors) {
        if (n <= 1) return 0L;
        if (divisors == null || divisors.length == 0) {
            // default to Euler 1 divisors if none provided
            return sumMultiples3or5Below(n);
        }

        // De-duplicate and drop non-positive divisors
        java.util.ArrayList<Integer> ds = new java.util.ArrayList<>();
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();
        for (int d : divisors) {
            if (d <= 0) continue;
            if (seen.add(d)) ds.add(d);
        }
        if (ds.isEmpty()) return 0L;

        long n1 = (long) n - 1L;
        int m = ds.size();
        long total = 0L;
        int maxMask = 1 << m;
        for (int mask = 1; mask < maxMask; mask++) {
            long l = 1L;
            boolean overflow = false;
            for (int j = 0; j < m; j++) {
                if ((mask & (1 << j)) != 0) {
                    l = lcmSafe(l, ds.get(j));
                    if (l <= 0 || l > n1) { // overflow or no contribution
                        overflow = true;
                        break;
                    }
                }
            }
            if (overflow || l > n1) continue;
            long k = n1 / l;
            long s = l * k * (k + 1L) / 2L;
            if ((Integer.bitCount(mask) & 1) == 1) total += s; else total -= s;
        }
        return total;
    }

    private static long gcd(long a, long b) {
        a = Math.abs(a); b = Math.abs(b);
        while (b != 0) { long t = a % b; a = b; b = t; }
        return a;
    }

    private static long lcmSafe(long a, long b) {
        if (a == 0 || b == 0) return 0;
        long g = gcd(a, b);
        long x = a / g;
        // overflow check for x * b
        if (x != 0 && Math.abs(b) > Long.MAX_VALUE / Math.abs(x)) return Long.MAX_VALUE;
        long l = x * b;
        return l < 0 ? Long.MAX_VALUE : l;
    }

    public static void main(String[] args) {
        int limit = 1000;
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            int[] ds = new int[args.length - 1];
            for (int i = 1; i < args.length; i++) ds[i - 1] = Integer.parseInt(args[i]);
            System.out.println(sumOfMultiplesBelow(limit, ds));
        } else {
            System.out.println(sumMultiples3or5Below(limit));
        }
    }
}
