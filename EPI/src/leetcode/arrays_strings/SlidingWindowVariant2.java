package leetcode.arrays_strings;

/**
 * @author gauravsardana
 * @since 28/12/24
 */
public class SlidingWindowVariant2 {

    /** https://leetcode.com/explore/featured/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4502/
     You are given a binary string s (a string containing only "0" and "1").
     You may choose up to one "0" and flip it to a "1".
     What is the length of the longest substring achievable that contains only "1"?
     **/
    /**
     * Question can be framed as get the length of substring with atmost one '0'
     * Eg : s = "1101100111"
     * answer : 5
     **/
    public static void main(String[] args) {
        System.out.println(findLength("1101100111"));
    }

    public static int findLength(String s) {

        int curr = 0;
        int answer = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            //logic for updating current
            if (s.charAt(right) == '0') {
                curr++;
            }

            while (curr > 1) {
                if (s.charAt(left) == '0') {
                    curr--;
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);

        }
        return answer;
    }
}
