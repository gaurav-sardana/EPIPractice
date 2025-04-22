package arraybootcamp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Playground {


    public static void main(String[] args) {
        System.out.println(X(new int[]{2, 3, 1, 2, 4, 3}, 7));
        System.out.println(X(new int[]{1,4,4}, 4));
        System.out.println(X(new int[]{1,1,1,1,1,1,1,1}, 11));



    }

    public static int X(int[] nums, int target) {

        Queue<Integer> q = new LinkedList<>();
        q.poll();
        int left = 0, right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (left <= right && right < nums.length) {
            sum += nums[right];


            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }

            right++;


        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
