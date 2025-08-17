// Euler 024: Lexicographic permutations
// Find the millionth lexicographic permutation of the digits 0..9.
public final class Euler024 {
    private static String nthPermutation(java.util.List<Character> items, long n) {
        int k = items.size();
        long[] fact = new long[k + 1];
        fact[0] = 1;
        for (int i = 1; i <= k; i++) fact[i] = fact[i - 1] * i;

        n--; // zero-based
        StringBuilder sb = new StringBuilder(k);
        java.util.ArrayList<Character> pool = new java.util.ArrayList<>(items);
        for (int i = k; i >= 1; i--) {
            long f = fact[i - 1];
            int idx = (int) (n / f);
            n %= f;
            sb.append(pool.remove(idx));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        java.util.ArrayList<Character> items = new java.util.ArrayList<>();
        for (char c = '0'; c <= '9'; c++) items.add(c);
        long n = args.length > 0 ? Long.parseLong(args[0]) : 1_000_000L;
        System.out.println(nthPermutation(items, n));
    }
}
