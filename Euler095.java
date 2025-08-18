// Euler 095: Amicable chains
// For numbers under one million, find the longest amicable chain and report its smallest member.
// https://projecteuler.net/problem=95
public final class Euler095 {
    public static void main(String[] args) {
        final int LIMIT = 1_000_000;
        int[] s = sumProperDivisors(LIMIT);

        boolean[] globalSeen = new boolean[LIMIT];
        int bestLen = 0;
        int bestMin = -1;

        int[] stack = new int[2048]; // reused path buffer; grows if needed
        for (int start = 2; start < LIMIT; start++) {
            if (globalSeen[start]) continue;

            int size = 0;
            java.util.HashMap<Integer, Integer> idx = new java.util.HashMap<>();
            int x = start;
            while (x > 0 && x < LIMIT && !globalSeen[x]) {
                Integer prev = idx.put(x, size);
                if (prev != null) {
                    // Found a cycle from prev..size-1
                    int cycleLen = size - prev;
                    int minVal = Integer.MAX_VALUE;
                    for (int i = prev; i < size; i++) {
                        minVal = Math.min(minVal, stack[i]);
                    }
                    if (cycleLen > bestLen || (cycleLen == bestLen && minVal < bestMin)) {
                        bestLen = cycleLen;
                        bestMin = minVal;
                    }
                    break;
                }
                if (size == stack.length) stack = java.util.Arrays.copyOf(stack, stack.length * 2);
                stack[size++] = x;
                x = s[x];
            }
            // Mark all nodes we visited in this walk as seen (within bounds)
            for (int i = 0; i < size; i++) globalSeen[stack[i]] = true;
        }

        System.out.println(bestMin);
    }

    private static int[] sumProperDivisors(int limit) {
        int[] sum = new int[limit];
        // 1 contributes to all n >= 2 via multiples of 1 starting at 2
        for (int i = 1; i <= limit / 2; i++) {
            for (int j = i * 2; j < limit; j += i) sum[j] += i;
        }
        // sum[1] = 0 by default
        return sum;
    }
}
