// Euler 096: Su Doku
// Solve Sudoku puzzles and sum the 3-digit numbers in the top-left of each solved grid.
// https://projecteuler.net/problem=96
import java.nio.file.*;
import java.util.*;

public final class Euler096 {
    public static void main(String[] args) {
        List<String> lines = loadDataset();
        if (lines == null) {
            System.out.println("DATA_FILE_NOT_FOUND");
            return;
        }
        List<int[][]> puzzles = parseSudokus(lines);
        long sum = 0;
        for (int[][] g : puzzles) {
            if (!solve(g)) { System.out.println("UNSOLVED"); return; }
            int val = g[0][0]*100 + g[0][1]*10 + g[0][2];
            sum += val;
        }
        System.out.println(sum);
    }

    private static List<String> loadDataset() {
        String[] files = {"p096_sudoku.txt", "sudoku.txt", "data/p096_sudoku.txt"};
        for (String f : files) {
            try { Path p = Path.of(f); if (Files.exists(p)) return Files.readAllLines(p); } catch (Exception ignore) {}
        }
        return null;
    }

    private static List<int[][]> parseSudokus(List<String> lines) {
        List<int[][]> out = new ArrayList<>();
        for (int i = 0; i < lines.size(); ) {
            String header = lines.get(i++).trim();
            if (!header.startsWith("Grid")) break;
            int[][] g = new int[9][9];
            for (int r = 0; r < 9 && i < lines.size(); r++, i++) {
                String s = lines.get(i).trim();
                for (int c = 0; c < 9; c++) g[r][c] = s.charAt(c) - '0';
            }
            out.add(g);
        }
        return out;
    }

    // Sudoku solver: bitmask candidates with MRV
    private static boolean solve(int[][] g) {
        int[] rows = new int[9], cols = new int[9], boxes = new int[9];
        Arrays.fill(rows, 0); Arrays.fill(cols, 0); Arrays.fill(boxes, 0);
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int v = g[r][c];
                if (v != 0) place(g, r, c, v, rows, cols, boxes);
            }
        }
        return dfs(g, rows, cols, boxes);
    }

    private static boolean dfs(int[][] g, int[] rows, int[] cols, int[] boxes) {
        int br=-1, bc=-1, bestMask=0, bestCount=10;
        for (int r=0;r<9;r++) for (int c=0;c<9;c++) if (g[r][c]==0) {
            int mask = candidatesMask(r,c,rows,cols,boxes);
            int cnt = Integer.bitCount(mask);
            if (cnt==0) return false;
            if (cnt<bestCount){ bestCount=cnt; bestMask=mask; br=r; bc=c; if (cnt==1) break; }
        }
        if (br==-1) return true;
        int box = (br/3)*3 + (bc/3);
        int mask = bestMask;
        while (mask!=0){
            int bit = mask & -mask; mask -= bit;
            int v = Integer.numberOfTrailingZeros(bit) + 1;
            g[br][bc]=v;
            rows[br] |= 1<<v; cols[bc] |= 1<<v; boxes[box] |= 1<<v;
            if (dfs(g, rows, cols, boxes)) return true;
            rows[br] &= ~(1<<v); cols[bc] &= ~(1<<v); boxes[box] &= ~(1<<v);
            g[br][bc]=0;
        }
        return false;
    }

    private static void place(int[][] g, int r, int c, int v, int[] rows, int[] cols, int[] boxes) {
        g[r][c]=v; rows[r]|=1<<v; cols[c]|=1<<v; boxes[(r/3)*3 + (c/3)]|=1<<v;
    }
    private static int candidatesMask(int r,int c,int[] rows,int[] cols,int[] boxes){
        int used = rows[r] | cols[c] | boxes[(r/3)*3 + (c/3)];
        int all = 0;
        for (int v=1; v<=9; v++) all |= 1<<v;
        return all & ~used;
    }
}
