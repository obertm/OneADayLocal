// Euler 067: Maximum path sum II
// Using a 100-row triangle (p067_triangle.txt), find the maximum total from top to bottom.
// https://projecteuler.net/problem=67
public final class Euler067 {
    public static void main(String[] args) {
        java.nio.file.Path p = java.nio.file.Path.of("p067_triangle.txt");
        if (!java.nio.file.Files.exists(p)) { System.out.println("DATA_FILE_NOT_FOUND"); return; }
        try {
            java.util.List<String> lines = java.nio.file.Files.readAllLines(p);
            int n = lines.size();
            int[][] tri = new int[n][];
            for (int i = 0; i < n; i++) {
                String[] parts = lines.get(i).trim().split("\\s+");
                tri[i] = new int[parts.length];
                for (int j = 0; j < parts.length; j++) tri[i][j] = Integer.parseInt(parts[j]);
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j < tri[i].length; j++) {
                    tri[i][j] += Math.max(tri[i+1][j], tri[i+1][j+1]);
                }
            }
            System.out.println(tri[0][0]);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
