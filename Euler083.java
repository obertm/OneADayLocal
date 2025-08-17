// Euler 083: Path sum: four ways
// Find the minimal path sum from the top left to the bottom right by moving in all four directions, using the same 80×80 matrix.
// https://projecteuler.net/problem=83
public final class Euler083 {
    public static void main(String[] args) {
        int[][] a = loadMatrix();
        int n = a.length;
        int N = n * n;
        long[] dist = new long[N]; java.util.Arrays.fill(dist, Long.MAX_VALUE/4);
        java.util.PriorityQueue<long[]> pq = new java.util.PriorityQueue<>(java.util.Comparator.comparingLong(x -> x[1]));
        dist[0] = a[0][0];
        pq.add(new long[]{0, dist[0]});
        int[] dr = {1,-1,0,0}; int[] dc = {0,0,1,-1};
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int)cur[0]; long du = cur[1];
            if (du != dist[u]) continue;
            if (u == N-1) break;
            int r = u / n, c = u % n;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                int v = nr * n + nc;
                long w = a[nr][nc];
                if (du + w < dist[v]) { dist[v] = du + w; pq.add(new long[]{v, dist[v]}); }
            }
        }
        System.out.println(dist[N-1]);
    }

    private static int[][] loadMatrix() {
        java.nio.file.Path p = java.nio.file.Path.of("p083_matrix.txt");
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
