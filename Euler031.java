// Euler 031: Coin sums
// How many different ways can £2 be made using any number of coins?
public final class Euler031 {
    public static void main(String[] args) {
        int target = args.length > 0 ? Integer.parseInt(args[0]) : 200;
        int[] coins = {1,2,5,10,20,50,100,200};
        long[] ways = new long[target + 1];
        ways[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= target; i++) ways[i] += ways[i - c];
        }
        System.out.println(ways[target]);
    }
}
