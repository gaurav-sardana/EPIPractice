package arraybootcamp.slidingwindow;

// You are given a binary string s (a string containing only "0" and "1"). You may choose up to one "0" and flip it to a "1".
// What is the length of the longest substring achievable that contains only "1"?
public class LongestLengthContainingOnly1 {

    public static void main(String[] args) {
        System.out.println(findLongestLength("1101100111"));
    }

    //time complexity is O(n) n is the length of the string
    //space complexity is O(1)

    public static int findLongestLength(String s) {

        int left = 0;
        int countZero = 0;
        int answer = 0;

        char[] charArray = s.toCharArray();

        for (int right = 0; right < charArray.length; right++) {

            if (s.charAt(right) == '0') {
                countZero++;
            }

            while (countZero > 1) {
                if (s.charAt(left) == '0') {
                    countZero--;
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}


