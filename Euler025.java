// Euler 025: 1000-digit Fibonacci number
// Find the index of the first term in the Fibonacci sequence to contain N digits (default 1000).
import java.math.BigInteger;

public final class Euler025 {
    public static void main(String[] args) {
        int digits = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
        BigInteger a = BigInteger.ONE; // F1
        BigInteger b = BigInteger.ONE; // F2
        int idx = 2;
        BigInteger tenPow = BigInteger.TEN.pow(digits - 1);
        while (b.compareTo(tenPow) < 0) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
            idx++;
        }
        System.out.println(idx);
    }
}
