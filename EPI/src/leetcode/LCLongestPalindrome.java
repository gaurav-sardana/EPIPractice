package leetcode;

/**
 * @author gauravsardana
 * @since 02/01/24
 */
public class LCLongestPalindrome {
    public static void main(String[] args) {
        longestPalindrome1("ababad");
    }

    //Time complexity: O(n3)
    //Space complexity: O(1)
    public static String longestPalindrome1(String str) {
        for (int length = str.length(); length > 0; length--) {
            for (int start = 0; start <= str.length() - length; start++) {
                if (check(start, length + start, str)) {
                    return str.substring(start, length + start);
                }
            }
        }
        return "";
    }

    public static boolean check(int i, int j, String s) {
        int initial = 0;
        int last = j - 1;
        while (initial < last) {
            if (s.charAt(initial) != s.charAt(last)) {
                return false;
            }
            initial++;
            last--;
        }
        return true;
    }

}
