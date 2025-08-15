public final class Euler004 {
    private static boolean isPalindrome(int n) {
        int original = n;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev == original;
    }

    public static int largestPalindromeProductNDigits(int digits) {
        if (digits < 1) throw new IllegalArgumentException("digits must be >= 1");
        int high = (int) Math.pow(10, digits) - 1;
        int low = (int) Math.pow(10, digits - 1);
        int max = 0;
        for (int i = high; i >= low; i--) {
            // If the best possible with this i is already less than max, stop.
            if (i * high <= max) break;
            for (int j = i; j >= low; j--) {
                int prod = i * j;
                if (prod <= max) break; // products will only get smaller as j decreases
                if (isPalindrome(prod)) {
                    max = prod;
                    break; // no need to try smaller j for this i
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int digits = 3;
        if (args.length > 0) {
            digits = Integer.parseInt(args[0]);
        }
        System.out.println(largestPalindromeProductNDigits(digits));
    }
}
