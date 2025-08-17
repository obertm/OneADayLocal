// Euler 052: Permuted multiples
// Find the smallest positive integer x such that 2x, 3x, 4x, 5x, and 6x contain the same digits.
// https://projecteuler.net/problem=52
public final class Euler052 {
    public static void main(String[] args) {
        System.out.println(findSmallestPermutedMultiple());
    }

    static int findSmallestPermutedMultiple() {
        for (int x = 1; ; x++) {
            String sig = signature(x);
            boolean ok = true;
            for (int k = 2; k <= 6; k++) {
                if (!sig.equals(signature(x * k))) { ok = false; break; }
            }
            if (ok) return x;
        }
    }

    private static String signature(int n) {
        char[] a = Integer.toString(n).toCharArray();
        java.util.Arrays.sort(a);
        return new String(a);
    }
}
