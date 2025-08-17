// Euler 049: Prime permutations
public final class Euler049 {
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int i = 3; i * i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }

    private static String sortDigits(int n) {
        char[] c = Integer.toString(n).toCharArray();
        java.util.Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args) {
        java.util.ArrayList<Integer> primes = new java.util.ArrayList<>();
        for (int i = 1001; i <= 9999; i += 2) if (isPrime(i)) primes.add(i);
        java.util.Map<String, java.util.List<Integer>> groups = new java.util.HashMap<>();
        for (int p : primes) groups.computeIfAbsent(sortDigits(p), k -> new java.util.ArrayList<>()).add(p);
        for (java.util.List<Integer> g : groups.values()) {
            if (g.size() < 3) continue;
            java.util.Collections.sort(g);
            int sz = g.size();
            for (int i = 0; i < sz; i++) for (int j = i + 1; j < sz; j++) {
                int a = g.get(i), b = g.get(j);
                int c = 2 * b - a;
                if (c != 1487 && c <= 9999 && java.util.Collections.binarySearch(g, c) >= 0) {
                    if (a != 1487) { System.out.println("" + a + b + c); return; }
                }
            }
        }
    }
}
