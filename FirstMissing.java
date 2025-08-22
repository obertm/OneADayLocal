import java.util.*;

public class FirstMissing {
    public static int firstMissingPositiveInteger(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;

        // Place each value v in [1..n] at index v-1 using in-place swaps.
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n) {
                int correctIdx = nums[i] - 1;
                if (nums[correctIdx] == nums[i]) break; // already correct or duplicate
                int tmp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = tmp;
            }
        }

        // The first index i not holding i+1 is the answer.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}
