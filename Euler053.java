// Euler 053: Combinatoric selections
// How many values of nCr, for 1 <= n <= 100, are greater than one million?
// https://projecteuler.net/problem=53
public final class Euler053 {
    public static void main(String[] args) {
        System.out.println(countOverOneMillion());
    }

    static int countOverOneMillion() {
        int count = 0;
        // Use multiplicative computation with early bailout to avoid overflow
        for (int n = 1; n <= 100; n++) {
            for (int r = 1; r <= n; r++) {
                if (combinationExceeds(n, r, 1_000_000)) {
                    // Due to symmetry, for this r and onwards up to n-r, all exceed
                    int rMax = n - r;
                    count += (rMax - r + 1);
                    break;
                }
            }
        }
        return count;
    }

    private static boolean combinationExceeds(int n, int r, int limit) {
        if (r > n - r) r = n - r; // symmetry
        double c = 1.0;
        for (int k = 1; k <= r; k++) {
            c = c * (n - r + k) / k;
            if (c > limit) return true;
        }
        return false;
    }
}
