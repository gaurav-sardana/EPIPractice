package arraybootcamp.slidingwindow;

public class LC713_SubArrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println(maxSubArrayLessThanK(new int[]{10, 5, 2, 6}, 1));
    }

    // once we get the answer, how many arrays can be formed? -> equal to the length of array.
    // number of arrays can be taken from left and right bound, by fixing right bound and how many steps left needs to take to reach right(that will be equal to length of sub array)
    //time complexity is O(n) n is the length of the array, work done in each loop iteration is amortized constant,
    //space complexity is O(1)
    public static int maxSubArrayLessThanK(int[] nums, int k) {

        int product = 1, left = 0, answer = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }
            answer += right - left + 1;
        }
        return answer;
    }
}
