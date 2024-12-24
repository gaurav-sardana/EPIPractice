package leetcode.arrays_strings;

/**
 * @author gauravsardana
 * @since 24/12/24
 */
public class LC26_RemoveDuplicateFromASortedArray {
    public static void main(String[] args) {
        final int[] nums = { 1, 1, 2 };
        System.out.println(removeDuplicates(nums));
    }

    //two pointer approach -> reader/writer variables
    //inplace algorithm (O(n))
    //time : O(n), space : O(1)
    public static int removeDuplicates(int[] nums) {
        int writer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[writer++] = nums[i];
            }
        }
        return writer;
    }
}
