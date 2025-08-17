// Euler 028: Number spiral diagonals
// Sum of the numbers on the diagonals in a spiral of size n (odd), default 1001.
public final class Euler028 {
    private static long diagonalSum(int n) {
        long sum = 1;
        int current = 1;
        for (int layer = 1; layer <= (n - 1) / 2; layer++) {
            int step = layer * 2;
            for (int k = 0; k < 4; k++) {
                current += step;
                sum += current;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 1001;
        System.out.println(diagonalSum(n));
    }
}
