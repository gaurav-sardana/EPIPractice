package leetcode.arrays_strings;

/**
 * @author gauravsardana
 * @since 24/12/24
 */
public class LC80_RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        final int[] nums = { 1, 1, 1, 2, 2, 3 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int pointer = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }
}
