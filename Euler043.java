// Euler 043: Sub-string divisibility
public final class Euler043 {
    private static long sum = 0;
    private static final int[] PR = {2,3,5,7,11,13,17};

    private static void perm(char[] arr, int l, int r) {
        if (l == r) {
            // Check property
            String s = new String(arr);
            if (arr[0] == '0') return; // leading zero not allowed for 0..9 pandigital?
            for (int i = 0; i < 7; i++) {
                int val = (s.charAt(i+1)-'0')*100 + (s.charAt(i+2)-'0')*10 + (s.charAt(i+3)-'0');
                if (val % PR[i] != 0) return;
            }
            sum += Long.parseLong(s);
            return;
        }
        for (int i = l; i <= r; i++) {
            char t = arr[l]; arr[l] = arr[i]; arr[i] = t;
            perm(arr, l+1, r);
            t = arr[l]; arr[l] = arr[i]; arr[i] = t;
        }
    }

    public static void main(String[] args) {
        // Ensure clean state if called multiple times in same JVM (test harness)
        sum = 0L;
        char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
        perm(digits, 0, digits.length - 1);
        System.out.println(sum);
    }
}
