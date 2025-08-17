// Euler 055: Lychrel numbers
// How many Lychrel numbers are there below ten-thousand under the given iteration rules?
// https://projecteuler.net/problem=55
public final class Euler055 {
    public static void main(String[] args) {
        System.out.println(countLychrelBelow10000());
    }

    static int countLychrelBelow10000() {
        int count = 0;
        for (int n = 1; n < 10_000; n++) {
            if (isLychrel(n)) count++;
        }
        return count;
    }

    private static boolean isLychrel(int n) {
        java.math.BigInteger x = java.math.BigInteger.valueOf(n);
        for (int i = 0; i < 50; i++) {
            x = x.add(reverseBig(x));
            if (isPalindrome(x)) return false;
        }
        return true;
    }

    private static java.math.BigInteger reverseBig(java.math.BigInteger x) {
        String s = x.toString();
        StringBuilder sb = new StringBuilder(s).reverse();
        return new java.math.BigInteger(sb.toString());
    }

    private static boolean isPalindrome(java.math.BigInteger x) {
        String s = x.toString();
        int i = 0, j = s.length() - 1;
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}
