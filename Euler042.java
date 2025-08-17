// Euler 042: Coded triangle numbers
// Reads words from p042_words.txt (CSV quoted) and counts how many are triangle words.
import java.nio.file.*;
import java.util.*;

public final class Euler042 {
    private static int wordValue(String w) {
        int s = 0; for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c >= 'A' && c <= 'Z') s += (c - 'A' + 1);
            else if (c >= 'a' && c <= 'z') s += (c - 'a' + 1);
        } return s;
    }

    public static void main(String[] args) {
        String file = args.length > 0 ? args[0] : "p042_words.txt";
        try {
            String raw = Files.readString(Path.of(file));
            String[] parts = raw.replace("\n", "").split(",");
            ArrayList<String> words = new ArrayList<>();
            int max = 0;
            for (String p : parts) {
                p = p.trim();
                if (p.startsWith("\"") && p.endsWith("\"")) p = p.substring(1, p.length()-1);
                if (p.isEmpty()) continue;
                words.add(p);
                max = Math.max(max, wordValue(p));
            }
            // Precompute triangle numbers up to max
            boolean[] tri = new boolean[max + 1];
            for (int n = 1, t = 1; t <= max; n++, t = n * (n + 1) / 2) tri[t] = true;
            int count = 0;
            for (String w : words) if (tri[wordValue(w)]) count++;
            System.out.println(count);
        } catch (Exception e) {
            System.out.println("DATA_FILE_NOT_FOUND");
        }
    }
}
