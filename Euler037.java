// Euler 037: Truncatable primes
public final class Euler037 {
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int i = 3; i * i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }

    private static boolean isTruncatable(int n) {
        if (n < 10) return false;
        String s = Integer.toString(n);
        for (int i = 1; i < s.length(); i++) {
            int left = Integer.parseInt(s.substring(i));
            int right = Integer.parseInt(s.substring(0, s.length() - i));
            if (!isPrime(left) || !isPrime(right)) return false;
        }
        return isPrime(n);
    }

    public static void main(String[] args) {
        int found = 0, n = 11; long sum = 0;
        while (found < 11) {
            if (isTruncatable(n)) { sum += n; found++; }
            n += 2; // skip even
        }
        System.out.println(sum);
    }
}
