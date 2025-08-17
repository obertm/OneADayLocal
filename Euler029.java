// Euler 029: Distinct powers
import java.math.BigInteger;
import java.util.HashSet;

public final class Euler029 {
    public static void main(String[] args) {
        int aMin = 2, aMax = 100, bMin = 2, bMax = 100;
        if (args.length == 4) {
            aMin = Integer.parseInt(args[0]);
            aMax = Integer.parseInt(args[1]);
            bMin = Integer.parseInt(args[2]);
            bMax = Integer.parseInt(args[3]);
        }
        HashSet<BigInteger> set = new HashSet<>();
        for (int a = aMin; a <= aMax; a++) {
            BigInteger base = BigInteger.valueOf(a);
            for (int b = bMin; b <= bMax; b++) {
                set.add(base.pow(b));
            }
        }
        System.out.println(set.size());
    }
}
