// Euler 058: Spiral primes
// What is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
// https://projecteuler.net/problem=58
public final class Euler058 {
    public static void main(String[] args) {
        System.out.println(sideLengthBelowTenPercent());
    }

    static int sideLengthBelowTenPercent() {
        int primes = 0;
        int total = 1; // center 1
        for (int layer = 1; ; layer++) {
            int side = layer * 2 + 1;
            long sq = (long) side * side;
            long c2 = sq - (side - 1);
            long c3 = sq - 2L * (side - 1);
            long c4 = sq - 3L * (side - 1);
            if (isPrime(c2)) primes++;
            if (isPrime(c3)) primes++;
            if (isPrime(c4)) primes++;
            total += 4;
            if ((long)primes * 10 < total) return side;
        }
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if ((n & 1) == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        long r = (long) Math.sqrt(n);
        for (long f = 5; f <= r; f += 6) {
            if (n % f == 0 || n % (f + 2) == 0) return false;
        }
        return true;
    }
}
