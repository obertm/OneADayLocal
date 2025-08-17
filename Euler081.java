// Euler 081: Path sum: two ways
// Find the minimal path sum from the top left to the bottom right by only moving right and down, using a given 80×80 matrix.
// https://projecteuler.net/problem=81
public final class Euler081 {
    public static void main(String[] args) {
        int[][] a = loadMatrix();
        int n = a.length;
        int[][] dp = new int[n][n];
        dp[0][0] = a[0][0];
        for (int i = 1; i < n; i++) dp[i][0] = dp[i-1][0] + a[i][0];
        for (int j = 1; j < n; j++) dp[0][j] = dp[0][j-1] + a[0][j];
        for (int i = 1; i < n; i++) for (int j = 1; j < n; j++) dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + a[i][j];
        System.out.println(dp[n-1][n-1]);
    }

    private static int[][] loadMatrix() {
        java.nio.file.Path p = java.nio.file.Path.of("p081_matrix.txt");
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
        // Minimal fallback small matrix (not the Euler data, lets the program run)
        return new int[][]{
            {131,673,234,103,18},
            {201,96,342,965,150},
            {630,803,746,422,111},
            {537,699,497,121,956},
            {805,732,524,37,331}
        };
    }
}
