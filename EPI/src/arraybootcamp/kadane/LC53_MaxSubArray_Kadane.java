package arraybootcamp.kadane;

public class LC53_MaxSubArray_Kadane {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));


    }

    // brute force
    // Time Complexity : O(n^2)
    // Space : O(1)
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    // normal sum problem
    public static int maxSubArray2(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : nums) {
            currSum = Math.max(0, currSum) + num;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }


    public static int maxSubArraySum(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            sum = Math.max(0, sum);
        }
        return maxSum;
    }
}
