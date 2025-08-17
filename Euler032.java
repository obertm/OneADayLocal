// Euler 032: Pandigital products
public final class Euler032 {
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

    public static void main(String[] args) {
        java.util.HashSet<Integer> products = new java.util.HashSet<>();
        // Two plausible digit splits: 1-digit x 4-digit = 4-digit, or 2-digit x 3-digit = 4-digit
        for (int a = 2; a < 100; a++) {
            int bStart = a < 10 ? 1234 : 123; // heuristic lower bound
            int bEnd = 9876;
            for (int b = bStart; b <= bEnd; b++) {
                int prod = a * b;
                String s = "" + a + b + prod;
                if (s.length() > 9) break;
                if (s.length() == 9 && isPandigital(s)) products.add(prod);
            }
        }
        int sum = 0; for (int p : products) sum += p;
        System.out.println(sum);
    }
}
