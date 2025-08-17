// Euler 082: Path sum: three ways
// Find the minimal path sum from the left column to the right column by moving only up, down, and right, using the same 80×80 matrix.
// https://projecteuler.net/problem=82
public final class Euler082 {
    public static void main(String[] args) {
        int[][] a = loadMatrix();
        int n = a.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][0] = a[i][0];
        for (int j = 1; j < n; j++) {
            // First pass: top to bottom
            dp[0][j] = dp[0][j-1] + a[0][j];
            for (int i = 1; i < n; i++) dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + a[i][j];
            // Second pass: bottom to top to allow downward moves
            for (int i = n - 2; i >= 0; i--) dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + a[i][j]);
        }
        int ans = Integer.MAX_VALUE; for (int i = 0; i < n; i++) ans = Math.min(ans, dp[i][n-1]);
        System.out.println(ans);
    }

    private static int[][] loadMatrix() {
        java.nio.file.Path p = java.nio.file.Path.of("p082_matrix.txt");
        try {
            if (java.nio.file.Files.exists(p)) {
                java.util.List<String> lines = java.nio.file.Files.readAllLines(p);
                int n = lines.size();
                int[][] a = new int[n][n];
                for (int i = 0; i < n; i++) {
                    String[] parts = lines.get(i).trim().split(",");
                    for (int j = 0; j < n; j++) a[i][j] = Integer.parseInt(parts[j]);
                }
                return a;
            }
        } catch (Exception ignore) {}
        // Fallback small matrix
        return new int[][]{
            {131,673,234,103,18},
            {201,96,342,965,150},
            {630,803,746,422,111},
            {537,699,497,121,956},
            {805,732,524,37,331}
        };
    }
}
