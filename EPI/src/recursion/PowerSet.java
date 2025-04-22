package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        System.out.println(subsets(ints));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subset(answer, 0, nums, temp);
        return answer;
    }


    public static void subset(List<List<Integer>> answer, int i, int[] nums, List<Integer> temp) {

        if (i >= nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        subset(answer, i + 1, nums, temp);
        temp.removeLast();
        subset(answer, i + 1, nums, temp);
    }
}
