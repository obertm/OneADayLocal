// Euler 039: Integer right triangles
public final class Euler039 {
    public static void main(String[] args) {
        int limit = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
        int bestP = 0, bestCount = 0;
        for (int p = 12; p <= limit; p++) {
            int count = 0;
            for (int a = 2; a < p / 3; a++) {
                for (int b = a + 1; a + b < p; b++) {
                    int c = p - a - b;
                    if (a * a + b * b == c * c) count++;
                }
            }
            if (count > bestCount) { bestCount = count; bestP = p; }
        }
        System.out.println(bestP);
    }
}
