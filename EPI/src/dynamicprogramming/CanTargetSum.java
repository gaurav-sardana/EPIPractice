package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanTargetSum {

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        List<Integer> answer = new ArrayList<>();
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}, new HashMap<>(), answer));
        System.out.println(answer);

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

    public static boolean howSum(int target, int[] nums, Map<Integer, Boolean> memo, List<Integer> answer) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return true;
        if (target < 0) return false;

        for (int num : nums) {
            int remaining = target - num;
            boolean canSum = howSum(remaining, nums, memo, answer);
            if (canSum) {
                memo.put(target, true);
                answer.add(num);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

}
