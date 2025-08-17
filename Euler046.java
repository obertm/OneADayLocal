// Euler 046: Goldbach's other conjecture
public final class Euler046 {
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int i = 3; i * i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }

    private static boolean canWrite(int n) {
        for (int p = 2; p < n; p++) if (isPrime(p)) {
            int rest = n - p;
            if (rest % 2 == 0) {
                int m2 = rest / 2;
                int r = (int) Math.sqrt(m2);
                if (r * r == m2) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int n = 9; ; n += 2) {
            if (isPrime(n)) continue;
            if (!canWrite(n)) { System.out.println(n); return; }
        }
    }
}
