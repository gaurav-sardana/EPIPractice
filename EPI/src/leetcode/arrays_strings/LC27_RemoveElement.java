package leetcode.arrays_strings;

/**
 * @author gauravsardana
 * @since 11/11/24
 */
public class LC27_RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        System.out.println(removeElement(nums, 2));
    }

    //two pointer approach -> reader/writer variables
    //inplace algorithm (O(n))
    //time : O(n), space : O(1)
    public static int removeElement(int[] nums, int val) {
        int writer = 0;
        for (int reader = 0; reader < nums.length; reader++) {
            if (nums[reader] != val) {
                nums[writer++] = nums[reader];
            }
        }
        return writer;
    }
}
