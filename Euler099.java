// Euler 099: Largest exponential
// Given a list of base-exponent pairs, determine which line number corresponds to the pair with the greatest numerical value.
// https://projecteuler.net/problem=99
import java.nio.file.*;
import java.util.*;

public final class Euler099 {
    public static void main(String[] args) {
        List<String> lines = loadDataset();
        if (lines == null) { System.out.println("DATA_FILE_NOT_FOUND"); return; }
        int bestLine = -1; double bestVal = -1;
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).trim().split(",");
            if (parts.length != 2) continue;
            double a = Double.parseDouble(parts[0]);
            double b = Double.parseDouble(parts[1]);
            double v = b * Math.log(a);
            if (v > bestVal) { bestVal = v; bestLine = i + 1; }
        }
        System.out.println(bestLine);
    }

    private static List<String> loadDataset() {
        String[] files = {"p099_base_exp.txt", "base_exp.txt", "data/p099_base_exp.txt"};
        for (String f : files) {
            try { Path p = Path.of(f); if (Files.exists(p)) return Files.readAllLines(p); } catch (Exception ignore) {}
        }
        return null;
    }
}
