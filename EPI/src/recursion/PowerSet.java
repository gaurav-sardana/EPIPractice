package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        String[] chars = {"1", "2", "3"};
        System.out.println(subsets(chars));
    }

    public static List<List<String>> subsets(String[] nums) {

        List<List<String>> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        subset(answer, 0, nums, temp);
        return answer;
    }


    public static void subset(List<List<String>> answer, int i, String[] chars, List<String> temp) {

        if (i >= chars.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        temp.add(chars[i]);
        subset(answer, i + 1, chars, temp);
        temp.remove(chars[i]);
        subset(answer, i + 1, chars, temp);
    }
}
