// Euler 030: Digit fifth powers
public final class Euler030 {
    private static int[] pow = new int[10];

    private static int upperBound(int p) {
        // For p, maximum sum for d digits is d * 9^p. Increase d until 10^{d-1} > d*9^p
        int d = 1;
        int ninePow = (int) Math.round(Math.pow(9, p));
        while (Math.pow(10, d - 1) <= d * ninePow) d++;
        return d * ninePow; // safe upper bound
    }

    public static void main(String[] args) {
        int p = args.length > 0 ? Integer.parseInt(args[0]) : 5;
        for (int i = 0; i <= 9; i++) pow[i] = (int) Math.round(Math.pow(i, p));
        int ub = upperBound(p);
        int total = 0;
        for (int n = 2; n <= ub; n++) {
            int s = 0, x = n;
            while (x > 0) { s += pow[x % 10]; x /= 10; }
            if (s == n) total += n;
        }
        System.out.println(total);
    }
}
