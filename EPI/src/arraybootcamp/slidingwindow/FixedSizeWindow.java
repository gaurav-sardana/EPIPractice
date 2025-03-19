package arraybootcamp.slidingwindow;

//Given an integer array nums and an integer k, find the sum of the subarray with the largest sum whose length is k.
public class FixedSizeWindow {

    public static void main(String[] args) {
        System.out.println(findBestSubArray(new int[]{10, 5, 2, 6}, 2));
        System.out.println(findBestSubArraySliding(new int[]{10, 5, 2, 6}, 2));
    }

    public static int findBestSubArray(int[] nums, int k) {
        int curr = 0;

        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        int ans = curr;

        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
        }
        return ans;

    }


    public static int findBestSubArraySliding(int[] nums, int k) {
        int size = 0, answer = 0, left = 0, curr = 0;

        for (int i = 0; i < nums.length; i++) {
            size++;
            while (size > k) {
                size--;
                curr -= nums[left++];
            }
            curr += nums[i];
            answer = Math.max(answer, curr);
        }
        return answer;

    }
}
