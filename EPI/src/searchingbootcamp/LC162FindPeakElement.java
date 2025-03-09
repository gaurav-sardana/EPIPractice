package searchingbootcamp;

public class LC162FindPeakElement {
    //solve with (n) time complexity
    public static int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
    }

    //solve with O(log(n)) time
    public static int findPeakElementV2(int[] nums) {
        return -1;
    }

}

