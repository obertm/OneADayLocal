// Euler 038: Pandigital multiples
public final class Euler038 {
    private static boolean isPandigital(String s) {
        if (s.length() != 9) return false;
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 9; i++) {
            int d = s.charAt(i) - '0';
            if (d == 0 || seen[d]) return false;
            seen[d] = true;
        }
        return true;
    }

    private static String concatProduct(int x) {
        StringBuilder sb = new StringBuilder();
        for (int n = 1; sb.length() < 9; n++) sb.append(x * n);
        return sb.toString();
    }

    public static void main(String[] args) {
        int best = 0;
        // Only need to try 1..9999; 5-digit x 1,2 already exceeds 9 digits.
        for (int x = 1; x < 10_000; x++) {
            String s = concatProduct(x);
            if (s.length() == 9 && isPandigital(s)) {
                int v = Integer.parseInt(s);
                if (v > best) best = v;
            }
        }
        System.out.println(best);
    }
}
