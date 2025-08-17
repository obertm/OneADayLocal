// Euler 091: Right triangles with integer coordinates
// Count the number of right triangles with integer coordinates with coordinates between (0,0) and (50,50).
// https://projecteuler.net/problem=91
public final class Euler091 {
    public static void main(String[] args) {
        int N = 50;
        if (args != null && args.length > 0) {
            try { N = Integer.parseInt(args[0]); } catch (Exception ignore) {}
        }
        long total = (long) N * N; // right angle at origin using (x,0) & (0,y)
        long sum = 0;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                sum += gcd(x, y);
            }
        }
        total += 2 * sum;
        System.out.println(total);
    }

    private static int gcd(int a, int b) {
        while (b != 0) { int t = a % b; a = b; b = t; }
        return a;
    }
}
