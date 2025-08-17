// Euler 040: Champernowne's constant
public final class Euler040 {
    private static int digitAt(int n) {
        int len = 1;
        long count = 9;
        long start = 1;
        while (n > len * count) { n -= len * count; len++; count *= 10; start *= 10; }
        long number = start + (n - 1) / len;
        int offset = (n - 1) % len;
        return Long.toString(number).charAt(offset) - '0';
    }

    public static void main(String[] args) {
        int[] pos = {1,10,100,1000,10000,100000,1000000};
        int prod = 1;
        for (int p : pos) prod *= digitAt(p);
        System.out.println(prod);
    }
}
