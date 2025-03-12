package hashtablesbootcamp;


import java.util.*;

// O(NK) ; N = number of strings & K = maximum length of a string
public class LC49_GroupAnagrams {
    public static List<List<String>> groupAnagram(String[] strs) {


        Map<String, List<String>> listMap = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);

            for (Character c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder str = new StringBuilder();
            for (int i : count) str.append("#").append(i);

            String key = str.toString();
            if (!listMap.containsKey(key)) {
                listMap.put(key, new ArrayList<>());
            }
            listMap.get(key).add(s);

        }
        return new ArrayList<>(listMap.values());


    }
}
