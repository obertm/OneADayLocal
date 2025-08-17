// Euler 017: Number letter counts
public final class Euler017 {
    private static final String[] ONES = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String numberToWords(int n) {
        if (n == 0) return "zero";
        if (n < 20) return ONES[n];
        if (n < 100) {
            int t = n / 10, r = n % 10;
            return r == 0 ? TENS[t] : TENS[t] + "-" + ONES[r];
        }
        if (n < 1000) {
            int h = n / 100, r = n % 100;
            if (r == 0) return ONES[h] + " hundred";
            return ONES[h] + " hundred and " + numberToWords(r);
        }
        if (n == 1000) return "one thousand";
        throw new IllegalArgumentException("Out of range: " + n);
    }

    public static int letterCount(String words) {
        int cnt = 0;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (c >= 'a' && c <= 'z') cnt++;
        }
        return cnt;
    }

    public static int totalLettersInRange(int from, int to) {
        int sum = 0;
        for (int n = from; n <= to; n++) sum += letterCount(numberToWords(n));
        return sum;
    }

    public static void main(String[] args) {
        int from = 1, to = 1000;
        if (args != null && args.length > 0) {
            try { from = Integer.parseInt(args[0]); } catch (Exception ignored) {}
        }
        if (args != null && args.length > 1) {
            try { to = Integer.parseInt(args[1]); } catch (Exception ignored) {}
        }
        System.out.println(totalLettersInRange(from, to));
    }
}
