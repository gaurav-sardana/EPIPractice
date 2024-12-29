package leetcode.arrays_strings;

/**
 * @author gauravsardana
 * @since 28/12/24
 */
public class LC209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        final int[] ints = { 2, 3, 1, 2, 4, 3 };
        System.out.println(minSubArrayLen(7, ints));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int answer = Integer.MAX_VALUE;
        int curr = 0;
        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr >= target) {
                answer = Math.min(answer, right - left + 1);
                curr -= nums[left++];
            }
        }
        return Integer.MAX_VALUE == answer ? 0 : answer;
    }
}
