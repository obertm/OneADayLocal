// Euler 081: Path sum: two ways
// Find the minimal path sum from the top left to the bottom right by only moving right and down, using a given 80×80 matrix.
// https://projecteuler.net/problem=81
public final class Euler081 {
    public static void main(String[] args) {
        int[][] matrix = loadMatrix();
        int n = matrix.length;
        int[] dp = new int[n];
        dp[0] = matrix[0][0];
        // Initialize first row
        for (int j = 1; j < n; j++) dp[j] = dp[j-1] + matrix[0][j];
        // Process each row
        for (int i = 1; i < n; i++) {
            dp[0] += matrix[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j-1]) + matrix[i][j];
            }
        }
        System.out.println(dp[n-1]);
    }

    private static int[][] loadMatrix() {
        java.nio.file.Path path = java.nio.file.Path.of("p081_matrix.txt");
        try {
            if (java.nio.file.Files.exists(path)) {
                return java.nio.file.Files.lines(path)
                        .map(line -> java.util.Arrays.stream(line.trim().split(","))
                                .mapToInt(Integer::parseInt).toArray())
                        .toArray(int[][]::new);
            }
        } catch (Exception e) {
            System.err.println("Failed to load matrix: " + e);
        }
        // Fallback: Project Euler example matrix
        return new int[][]{
            {131,673,234,103,18},
            {201,96,342,965,150},
            {630,803,746,422,111},
            {537,699,497,121,956},
            {805,732,524,37,331}
        };
    }
}
