package arraybootcamp.slidingwindow;

public class LongestSubarraySumIsEqualLessThanK {

    public static void main(String[] args) {

        System.out.println(findLength(new int[]{1, 2, 3, 4, 5, 6}, 22));

    }


    // Given an array of positive integers nums and an integer k, find the length of the longest subarray whose sum is less than or equal to k
    //time complexity is O(n) n is the array length
    //space complexity is O(1)
    public static int findLength(int[] arr, int k) {
        int left = 0;
        int currentSum = 0;
        int ans = 0;

        for (int right = 0; right < arr.length; right++) {

            currentSum += arr[right];

            while (currentSum > k) {
                currentSum -= arr[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
