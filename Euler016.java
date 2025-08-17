// Euler 016: Power digit sum
import java.math.BigInteger;

public final class Euler016 {
    public static int sumDigitsOfTwoPow(int n) {
        BigInteger val = BigInteger.ONE.shiftLeft(n); // 2^n
        String s = val.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';
        return sum;
    }

    public static void main(String[] args) {
        int n = 1000;
        if (args != null && args.length > 0) {
            try { n = Integer.parseInt(args[0]); } catch (Exception ignored) {}
        }
        System.out.println(sumDigitsOfTwoPow(n));
    }
}
