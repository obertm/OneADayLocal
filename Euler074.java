// Euler 074: Digit factorial chains
// How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
// https://projecteuler.net/problem=74
import java.util.*;

public final class Euler074 {
    private static final int[] FACT = new int[10];
    static { FACT[0]=1; int f=1; for (int i=1;i<=9;i++){ f*=i; FACT[i]=f; } }

    public static void main(String[] args) {
        int limit = 1_000_000;
        // Upper bound for values reached: numbers quickly collapse below 3M
        int maxVal = 3_000_000;
        int[] memo = new int[maxVal+1]; // 0 means unknown, else chain length
        int target = 60;
        int count = 0;
        for (int n = 1; n < limit; n++) {
            if (chainLength(n, memo) == target) count++;
        }
        System.out.println(count);
    }

    private static int next(int n) {
        int s = 0;
        while (n > 0) { s += FACT[n%10]; n/=10; }
        return s;
    }

    private static int chainLength(int start, int[] memo) {
        Map<Integer,Integer> seen = new HashMap<>();
        int n = start; int len = 0;
        while (true) {
            if (n < memo.length && memo[n] != 0) {
                int add = memo[n];
                // propagate back
                for (Map.Entry<Integer,Integer> e : seen.entrySet()) {
                    int val = e.getKey();
                    int stepsFromVal = add + (len - e.getValue());
                    if (val < memo.length) memo[val] = stepsFromVal;
                }
                return add + len;
            }
            Integer at = seen.putIfAbsent(n, len);
            if (at != null) {
                // loop found; nodes before loop get total length; loop nodes get cycle length
                int cycleLen = len - at;
                for (Map.Entry<Integer,Integer> e : seen.entrySet()) {
                    int val = e.getKey();
                    int pos = e.getValue();
                    int steps = pos < at ? len - pos : cycleLen;
                    if (val < memo.length) memo[val] = steps;
                }
                return len;
            }
            len++;
            n = next(n);
        }
    }
}
