// Euler 091: Right triangles with integer coordinates
// Count the number of right triangles with integer coordinates with coordinates between (0,0) and (50,50).
// https://projecteuler.net/problem=91
public final class Euler091 {
    public static void main(String[] args) {
        int N = 50;
        if (args != null && args.length > 0) {
            try { N = Integer.parseInt(args[0]); } catch (Exception ignore) {}
        }
    long total = 1L * N * N; // right angle at origin (axis-aligned)
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                int g = gcd(x, y);
                int dx = y / g;
                int dy = x / g;
                int k1 = Math.min(x / dx, (N - y) / dy);      // steps in (-dx,+dy)
                int k2 = Math.min((N - x) / dx, y / dy);      // steps in (+dx,-dy)
                total += (long)k1 + k2; // sum of both perpendicular directions
            }
        }
    // Add right triangles whose right angle lies on positive x-axis or y-axis (excluding origin)
    // For each point (x,0), x=1..N there are N choices for the vertical point (x,y) with y>0 and origin forms the third vertex.
    // Similarly for (0,y), y=1..N. These contribute 2*N^2 additional axis-aligned right triangles.
    total += 2L * N * N;
    System.out.println(total);
    }

    private static int gcd(int a, int b) { while (b != 0) { int t = a % b; a = b; b = t; } return a; }

}
