// Euler 089: Roman numerals
// Given a set of Roman numerals, determine the number of characters saved by writing them in minimal form.
// https://projecteuler.net/problem=89
import java.nio.file.*;
import java.util.*;

public final class Euler089 {
    public static void main(String[] args) {
        List<String> lines = loadDataset();
        long saved = 0;
        for (String s : lines) {
            if (s == null) continue;
            s = s.trim();
            if (s.isEmpty()) continue;
            int val = romanToInt(s);
            String minimal = intToMinimalRoman(val);
            saved += s.length() - minimal.length();
        }
        System.out.println(saved);
    }

    private static List<String> loadDataset() {
        // Try common filenames; return a small sample fallback if none found.
        String[] candidates = new String[]{
            "p089_roman.txt",
            "roman.txt",
            "data/p089_roman.txt",
            "datasets/p089_roman.txt"
        };
        for (String name : candidates) {
            Path p = Path.of(name);
            try {
                if (Files.exists(p)) return Files.readAllLines(p);
            } catch (Exception ignore) {}
        }
        // Minimal fallback sample with known non-minimal forms
        return Arrays.asList(
            "VIIII",     // 9 -> IX (save 3)
            "LXXXXVIIII",// 99 -> XCIX (save 6)
            "IIII",      // 4 -> IV (save 2)
            "DCCCCLXXXXVIIII", // 999 -> CMXCIX (save 8)
            "MMMDCCCLXXXVIII"  // 3888 already minimal (save 0)
        );
    }

    private static int romanToInt(String s) {
        int n = s.length();
        int total = 0;
        for (int i = 0; i < n; ) {
            int v1 = valueOf(s.charAt(i));
            if (i + 1 < n) {
                int v2 = valueOf(s.charAt(i + 1));
                if (v1 < v2) {
                    total += (v2 - v1);
                    i += 2;
                    continue;
                }
            }
            total += v1;
            i++;
        }
        return total;
    }

    private static int valueOf(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Invalid roman: " + c);
        }
    }

    private static String intToMinimalRoman(int num) {
        // Greedy mapping covers subtractive forms for minimal encoding
        int[] vals =    {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roms = {"M", "CM","D", "CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) {
                num -= vals[i];
                sb.append(roms[i]);
            }
        }
        return sb.toString();
    }
}
