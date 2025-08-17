// Euler 041: Pandigital prime
public final class Euler041 {
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int i = 3; i * i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }

    private static void permute(char[] arr, int l, int r, java.util.function.IntConsumer consumer) {
        if (l == r) {
            int v = 0;
            for (char c : arr) v = v * 10 + (c - '0');
            consumer.accept(v);
            return;
        }
        for (int i = l; i <= r; i++) {
            char tmp = arr[l]; arr[l] = arr[i]; arr[i] = tmp;
            permute(arr, l + 1, r, consumer);
            tmp = arr[l]; arr[l] = arr[i]; arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
    int best = 0;
    // Valid n: 7, 4 (since sum 1..n divisible by 3 eliminates others)
        // We'll manually handle to keep Java simple
        java.util.function.Function<char[], Integer> maxPrimePerm = (chars) -> {
            final int[] localBest = {0};
            permute(chars, 0, chars.length - 1, (int v) -> { if (v > localBest[0] && isPrime(v)) localBest[0] = v; });
            return localBest[0];
        };
        best = Math.max(best, maxPrimePerm.apply(new char[]{'1','2','3','4','5','6','7'}));
        best = Math.max(best, maxPrimePerm.apply(new char[]{'1','2','3','4'}));
        System.out.println(best);
    }
}
