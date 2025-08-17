// Euler 020: Factorial digit sum
import java.math.BigInteger;

public final class Euler020 {
    public static int sumDigitsOfFactorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) fact = fact.multiply(BigInteger.valueOf(i));
        String s = fact.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';
        return sum;
    }

    public static void main(String[] args) {
        int n = 100;
        if (args != null && args.length > 0) {
            try { n = Integer.parseInt(args[0]); } catch (Exception ignored) {}
        }
        System.out.println(sumDigitsOfFactorial(n));
    }
}
