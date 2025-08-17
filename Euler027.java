// Euler 027: Quadratic primes
// Find the product of coefficients, a and b, for the quadratic expression n^2 + a*n + b
// that produces the maximum number of primes for consecutive values of n, starting with n=0,
// where |a| < 1000 and |b| <= 1000.
public final class Euler027 {
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int i = 3; i * i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        int bestA = 0, bestB = 0, bestLen = 0;
        // b must be prime for n=0
        java.util.ArrayList<Integer> primesB = new java.util.ArrayList<>();
        for (int b = -1000; b <= 1000; b++) if (isPrime(Math.abs(b))) primesB.add(b);
        for (int a = -999; a <= 999; a++) {
            for (int b : primesB) {
                int n = 0;
                while (true) {
                    int v = n * n + a * n + b;
                    if (!isPrime(v)) break;
                    n++;
                }
                if (n > bestLen) { bestLen = n; bestA = a; bestB = b; }
            }
        }
        System.out.println(bestA * bestB);
    }
}
