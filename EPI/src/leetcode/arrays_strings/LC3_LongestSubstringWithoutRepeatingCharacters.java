package leetcode.arrays_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author gauravsardana
 * @since 28/12/24
 */
public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //        printAllSubsString("1234");
        //        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstringUsingHashMap("pwwkew"));
        System.out.println(lengthOfLongestSubstringUsingHashMapV2("pwwkew"));

    }

    // time O(n)

    public static int lengthOfLongestSubstringUsingHashMapV2(String str) {
        int n = str.length(), ans = 0;
        Map<Character, Integer> charToNextIndex = new HashMap<>();
        // index after current character

        for (int left = 0, right = 0; right < n; right++) {
            if (charToNextIndex.containsKey(str.charAt(right))) {
                left = Math.max(left, charToNextIndex.get(str.charAt(right)));
            }

            ans = Math.max(ans, right - left + 1);
            charToNextIndex.put(str.charAt(right), right + 1);
        }
        return ans;
    }

    // time O(n)
    //space O(min(n,m))
    public static int lengthOfLongestSubstringUsingHashMap(String str) {
        int right = 0;
        int left = 0;
        int res = 0;

        final Map<Character, Integer> map = new HashMap<>();

        while (right < str.length()) {
            final char c = str.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                final char c1 = str.charAt(left);
                map.put(c1, map.get(c1) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;

    }

    // time O(n^3)
    public static void printAllSubsString(String str) {
        for (int length = str.length(); length > 0; length--) {
            for (int start = 0; start <= str.length() - length; start++) {
                System.out.println(str.substring(start, start + length));
            }
        }
    }

    public static int lengthOfLongestSubstring(String str) {
        for (int length = str.length(); length > 0; length--) {
            for (int start = 0; start <= str.length() - length; start++) {
                if (checkRepetition(start, start + length - 1, str)) {
                    return length;
                }
            }
        }
        return 0;
    }

    public static boolean checkRepetition(int start, int end, String str) {
        final Set<Character> characterSet = new HashSet<>();
        for (int i = start; i <= end; i++) {
            final char c = str.charAt(i);
            if (characterSet.contains(c)) {
                return false;
            }
            characterSet.add(c);
        }
        return true;
    }
}
