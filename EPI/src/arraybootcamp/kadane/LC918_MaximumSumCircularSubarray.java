package arraybootcamp.kadane;

public class LC918_MaximumSumCircularSubarray {
    public static void main(String[] args) {
        byte[] bytes = new byte[10];
        char[] chars = new char[10];
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
        System.out.println(maxSubArray(new int[]{5, -3, 5}));
        System.out.println(maxSubArray2(new int[]{5, -3, 5}));


    }

    // here we can get the special sum using prefix sum and suffuix sum
    // to get special sum we need prefix_sum(i) + max(suffix_sum(i+1 ... n-1))
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int suffixSum = nums[n - 1];
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(suffixSum, rightMax[i + 1]);
        }

        int maxSum = nums[0];
        int currMax = 0;
        int specialSum = nums[0];
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            currMax = Math.max(0, currMax) + nums[i];
            maxSum = Math.max(currMax, maxSum);

            prefixSum += nums[i];
            if (i < n - 1) {
                specialSum = Math.max(prefixSum + rightMax[i + 1], specialSum);
            }

        }
        return Math.max(maxSum, specialSum);
    }

    // get max Sum from Kadane
    // get Min sum fro Kadane
    public static int maxSubArray2(int[] nums) {

        int currMax = 0;
        int currMin = 0;

        int maxSum = nums[0];
        int minSum = nums[0];

        int totalSum = 0;

        for (int n : nums) {

            //using kadane to get max Sum
            currMax = Math.max(0, currMax) + n;
            maxSum = Math.max(currMax, maxSum);

            //Kadane's but with min to find minimum subarray
            currMin = Math.min(0, currMin) + n;
            minSum = Math.min(currMin, minSum);

            totalSum += n;
        }
        if (totalSum == minSum) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }


}
