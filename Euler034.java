// Euler 034: Digit factorials
public final class Euler034 {
    public static void main(String[] args) {
        int[] fact = new int[10];
        fact[0] = 1; int f = 1;
        for (int i = 1; i <= 9; i++) { f *= i; fact[i] = f; }
        int ub = 7 * fact[9]; // 2540160
        int total = 0;
        for (int n = 10; n <= ub; n++) {
            int s = 0, x = n;
            while (x > 0) { s += fact[x % 10]; x /= 10; }
            if (s == n) total += n;
        }
        System.out.println(total);
    }
}
