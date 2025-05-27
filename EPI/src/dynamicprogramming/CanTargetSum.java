package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanTargetSum {

    public static void main(String[] args) {
        System.out.println(canSum(1300, new int[]{7, 14}, new HashMap<>()));

    }

    /*
     *  Brute Force ; time : O(m^n) space : O(m)
     *  Memoized (Optimised ); time : O(m *n)  space : O(m)
     *
     * */

    public static boolean canSum(int target, int[] nums, Map<Integer, Boolean> memo) {

        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return true;
        if (target < 0) return false;

        for (int num : nums) {
            int remaining = target - num;
            boolean canSum = canSum(remaining, nums, memo);

            if (canSum) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

}
