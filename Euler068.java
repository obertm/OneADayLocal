// Euler 068: Magic 5-gon ring
// What is the maximum 16-digit string for a "magic" 5-gon ring?
// https://projecteuler.net/problem=68
public final class Euler068 {
    private static String best = "";

    public static void main(String[] args) {
        // Outer nodes must include 10 to reach 16 digits; use 1..10 once each
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) nums[i] = i + 1;
        permute(nums, 0);
        System.out.println(best);
    }

    private static void permute(int[] a, int idx) {
        if (idx == a.length) {
            // outer: a0,a1,a2,a3,a4; inner: a5..a9
            int[] o = {a[0],a[1],a[2],a[3],a[4]};
            int[] i = {a[5],a[6],a[7],a[8],a[9]};
            // ensure 10 is outer to get 16-digit string and minimal outer start
            boolean tenInner = false; for (int v : i) if (v == 10) { tenInner = true; break; }
            if (tenInner) return;
            int sum = o[0] + i[0] + i[1];
            for (int k = 1; k < 5; k++) if (o[k] + i[k] + i[(k+1)%5] != sum) return;
            // start from minimal outer node to define rotation
            int start = 0; for (int k = 1; k < 5; k++) if (o[k] < o[start]) start = k;
            StringBuilder sb = new StringBuilder();
            for (int t = 0; t < 5; t++) {
                int k = (start + t) % 5;
                sb.append(o[k]).append(i[k]).append(i[(k+1)%5]);
            }
            String s = sb.toString();
            if (s.length() == 16 && s.compareTo(best) > 0) best = s;
            return;
        }
        for (int j = idx; j < a.length; j++) { swap(a, idx, j); permute(a, idx + 1); swap(a, idx, j); }
    }

    private static void swap(int[] a, int i, int j) { int t = a[i]; a[i]=a[j]; a[j]=t; }
}
