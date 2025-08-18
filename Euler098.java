// Euler 098: Anagramic squares
// Find the largest square number formed by any member of a pair of anagramic words.
// https://projecteuler.net/problem=98
import java.nio.file.*;
import java.util.*;

public final class Euler098 {
    public static void main(String[] args) {
        List<String> words = loadWords();
        if (words == null) { System.out.println("DATA_FILE_NOT_FOUND"); return; }
        Map<String, List<String>> groups = new HashMap<>();
        for (String w : words) {
            String k = sort(w);
            groups.computeIfAbsent(k, _k -> new ArrayList<>()).add(w);
        }
        int best = 0;
        for (List<String> g : groups.values()) {
            if (g.size() < 2) continue;
            int L = g.get(0).length();
            List<Integer> squares = squaresOfLength(L);
            // Pre-index by pattern
            Map<String, List<Integer>> patternToSquares = new HashMap<>();
            for (int s : squares) {
                patternToSquares.computeIfAbsent(pattern(Integer.toString(s)), _k -> new ArrayList<>()).add(s);
            }
            for (int i = 0; i < g.size(); i++) {
                for (int j = i + 1; j < g.size(); j++) {
                    String a = g.get(i), b = g.get(j);
                    String p = pattern(a);
                    List<Integer> cand = patternToSquares.get(p);
                    if (cand == null) continue;
                    for (int sq : cand) {
                        Map<Character, Character> map = new HashMap<>();
                        Map<Character, Character> rmap = new HashMap<>();
                        if (!buildMap(a, Integer.toString(sq), map, rmap)) continue;
                        int sb = applyMap(b, map);
                        if (sb != -1 && isSquare(sb)) best = Math.max(best, Math.max(sq, sb));
                    }
                }
            }
        }
        System.out.println(best);
    }

    private static List<String> loadWords() {
        String[] files = {"p098_words.txt", "words.txt", "data/p098_words.txt"};
        for (String f : files) {
            try {
                Path p = Path.of(f);
                if (Files.exists(p)) {
                    String content = Files.readString(p).trim();
                    // Words are quoted and comma-separated
                    String[] parts = content.split(",");
                    List<String> list = new ArrayList<>();
                    for (String raw : parts) {
                        String w = raw.replace("\"", "").trim();
                        if (!w.isEmpty()) list.add(w);
                    }
                    return list;
                }
            } catch (Exception ignore) {}
        }
        return null;
    }

    private static String sort(String s){ char[] c=s.toCharArray(); java.util.Arrays.sort(c); return new String(c);}    
    private static String pattern(String s){
        Map<Character,Integer> idx = new HashMap<>();
        StringBuilder sb = new StringBuilder(); int k=0;
        for(char ch: s.toCharArray()){
            Integer id = idx.get(ch); if(id==null){ id=k; idx.put(ch,k++);} sb.append((char)('a'+id));
        }
        return sb.toString();
    }
    private static List<Integer> squaresOfLength(int L){
        int lo = (int)Math.ceil(Math.sqrt(Math.pow(10, L-1)));
        int hi = (int)Math.floor(Math.sqrt(Math.pow(10, L)-1));
        List<Integer> out = new ArrayList<>();
        for (int x=lo; x<=hi; x++) out.add(x*x);
        return out;
    }
    private static boolean buildMap(String word, String digits, Map<Character,Character> map, Map<Character,Character> rmap){
        if (digits.charAt(0) == '0') return false;
        for (int i=0;i<word.length();i++){
            char w = word.charAt(i), d = digits.charAt(i);
            Character m = map.get(w), rm = rmap.get(d);
            if (m==null && rm==null){ map.put(w,d); rmap.put(d,w);} else if (m==null || rm==null || m!=d || rm!=w){ return false; }
        }
        return true;
    }
    private static int applyMap(String word, Map<Character,Character> map){
        if (map.get(word.charAt(0))=='0') return -1;
        int v=0; for(char w: word.toCharArray()){ char d = map.getOrDefault(w, (char)0); if(d==0) return -1; v = v*10 + (d-'0'); }
        return v;
    }
    private static boolean isSquare(int n){ int r=(int)Math.sqrt(n); return r*r==n; }
}
