// Euler 008: Largest product in a series
public final class Euler008 {
    private static final String NUM = (
        "73167176531330624919225119674426574742355349194934" +
        "96983520312774506326239578318016984801869478851843" +
        "85861560789112949495459501737958331952853208805511" +
        "12540698747158523863050715693290963295227443043557" +
        "66896648950445244523161731856403098711121722383113" +
        "62229893423380308135336276614282806444486645238749" +
        "30358907296290491560440772390713810515859307960866" +
        "70172427121883998797908792274921901699720888093776" +
        "65727333001053367881220235421809751254540594752243" +
        "52584907711670556013604839586446706324415722155397" +
        "53697817977846174064955149290862569321978468622482" +
        "83972241375657056057490261407972968652414535100474" +
        "82166370484403199890008895243450658541227588666881" +
        "16427171479924442928230863465674813919123162824586" +
        "17866458359124566529476545682848912883142607690042" +
        "24219022671055626321111109370544217506941658960408" +
        "07198403850962455444362981230987879927244284909188" +
        "84580156166097919133875499200524063689912560717606" +
        "05886116467109405077541002256983155200055935729725" +
        "71636269561882670428252483600823257530420752963450"
    );

    public static long maxAdjacentProduct(String digits, int window) {
        int n = digits.length();
        if (window <= 0 || window > n) throw new IllegalArgumentException("invalid window");
        long best = 0;
        int i = 0;
        while (i < n) {
            // Skip zeros and split segments by zero
            while (i < n && digits.charAt(i) == '0') i++;
            int j = i;
            while (j < n && digits.charAt(j) != '0') j++;
            int len = j - i;
            if (len >= window) {
                // Compute product for the first window in the segment
                long prod = 1;
                for (int k = 0; k < window; k++) {
                    prod *= (digits.charAt(i + k) - '0');
                }
                best = Math.max(best, prod);
                // Slide window across the segment, recomputing when digit becomes zero or non-invertible
                for (int start = i + 1; start + window <= j; start++) {
                    int outgoing = digits.charAt(start - 1) - '0';
                    int incoming = digits.charAt(start + window - 1) - '0';
                    if (outgoing != 0) {
                        prod = prod / outgoing * incoming;
                    } else {
                        // Should not happen within zero-free segment, but keep safe
                        prod = 1;
                        for (int k = 0; k < window; k++) prod *= (digits.charAt(start + k) - '0');
                    }
                    if (prod > best) best = prod;
                }
            }
            i = j + 1;
        }
        return best;
    }

    public static void main(String[] args) {
        int window = 13;
        if (args.length > 0) window = Integer.parseInt(args[0]);
        System.out.println(maxAdjacentProduct(NUM, window));
    }
}
