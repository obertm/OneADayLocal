// Euler 091: Right triangles with integer coordinates
// Count the number of right triangles with integer coordinates with coordinates between (0,0) and (50,50).
// https://projecteuler.net/problem=91
public final class Euler091 {
    public static void main(String[] args) {
        int N = 50;
        if (args != null && args.length > 0) {
            try { N = Integer.parseInt(args[0]); } catch (Exception ignore) {}
        }
    // Count right triangles with vertices at (0,0), (x1,y1), (x2,y2), 0<=x,y<=N.
    // Correct count: N*N (axis-aligned with right angle at origin) + 2 * sum_{x=1..N} sum_{y=1..N} gcd(x,y)
    long total = 1L * N * N;
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
