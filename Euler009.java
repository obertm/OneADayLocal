// Euler 009: Special Pythagorean triplet
public final class Euler009 {
    // Finds product a*b*c for the unique Pythagorean triplet with a+b+c = sum.
    // Returns -1 if none found.
    public static long tripletProductForSum(int sum) {
        // Using Euclid's formula: a = d*(m^2 - n^2), b = d*(2mn), c = d*(m^2 + n^2)
        // Sum = d * 2m(m+n) = sum => d must divide sum and choose m,n accordingly.
        for (int m = 2; 2 * m * (m + 1) <= sum; m++) {
            for (int n = 1; n < m; n++) {
                int twoMmn = 2 * m * (m + n);
                if (sum % twoMmn != 0) continue;
                int d = sum / twoMmn;
                long a = d * (long) (m * m - n * n);
                long b = d * (long) (2 * m * n);
                long c = d * (long) (m * m + n * n);
                if (a <= 0 || b <= 0 || c <= 0) continue;
                if (a * a + b * b == c * c && a + b + c == sum) {
                    return a * b * c;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int sum = 1000;
        if (args.length > 0) sum = Integer.parseInt(args[0]);
        System.out.println(tripletProductForSum(sum));
    }
}
