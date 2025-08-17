// Euler 015: Lattice paths
import java.math.BigInteger;

public final class Euler015 {
    public static BigInteger latticePaths(int n) {
        // Number of lattice paths in n x n grid = C(2n, n)
        return binomial(2 * n, n);
    }

    private static BigInteger binomial(int n, int k) {
        if (k < 0 || k > n) return BigInteger.ZERO;
        if (k == 0 || k == n) return BigInteger.ONE;
        if (k > n - k) k = n - k; // symmetry
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            res = res.multiply(BigInteger.valueOf(n - k + i))
                     .divide(BigInteger.valueOf(i));
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 20;
        if (args != null && args.length > 0) {
            try { n = Integer.parseInt(args[0]); } catch (Exception ignored) {}
        }
        System.out.println(latticePaths(n));
    }
}
