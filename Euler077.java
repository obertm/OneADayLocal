// Euler 077: Prime summations
// What is the first value which can be written as the sum of primes in over five thousand different ways?
// https://projecteuler.net/problem=77
import java.util.*;

public final class Euler077 {
    public static void main(String[] args) {
        int targetWays = 5000;
        // Incrementally increase N and count partitions using primes as coins
        for (int N = 2; ; N++) {
            int[] primes = primesUpTo(N);
            long[] ways = new long[N + 1];
            ways[0] = 1;
            for (int p : primes) {
                for (int s = p; s <= N; s++) ways[s] += ways[s - p];
            }
            if (ways[N] > targetWays) { System.out.println(N); return; }
        }
    }

    private static int[] primesUpTo(int n) {
        boolean[] isComp = new boolean[n + 1];
        int cnt = 0;
        for (int i = 2; i * i <= n; i++) if (!isComp[i]) for (int j = i * i; j <= n; j += i) isComp[j] = true;
        for (int i = 2; i <= n; i++) if (!isComp[i]) cnt++;
        int[] ps = new int[cnt]; int k = 0;
        for (int i = 2; i <= n; i++) if (!isComp[i]) ps[k++] = i;
        return ps;
    }
}
