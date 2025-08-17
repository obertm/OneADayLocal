// Euler 036: Double-base palindromes
public final class Euler036 {
    private static boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    public static void main(String[] args) {
        int limit = args.length > 0 ? Integer.parseInt(args[0]) : 1_000_000;
        long sum = 0;
        for (int i = 1; i < limit; i++) {
            String d = Integer.toString(i);
            if (!isPal(d)) continue;
            String b = Integer.toBinaryString(i);
            if (isPal(b)) sum += i;
        }
        System.out.println(sum);
    }
}
