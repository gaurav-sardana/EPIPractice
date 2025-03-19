package arraybootcamp.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words
public class LC30_SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {

    }

    private Map<String, Integer> wordsCount = new HashMap<String, Integer>();
    private int wordLength;
    private int subStringLen;
    int wordsSize;


    public List<Integer> findSubStringUsingSlidingWindow(String s, String[] words) {
        return null;
    }

    public List<Integer> findSubString(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        wordsSize = words.length;
        wordLength = words[0].length();
        subStringLen = wordsSize * wordLength;
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }


        for (int i = 0; i < s.length() - subStringLen + 1; i++) {
            if (check(i, s)) {
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean check(int start, String s) {

        Map<String, Integer> integerMap = new HashMap<>(wordsCount);
        int wordMatchCount = 0;

        for (int j = start; j < start + subStringLen; j += wordLength) {

            String subStr = s.substring(j, j + wordLength);
            if (integerMap.getOrDefault(subStr, 0) != 0) {
                integerMap.put(subStr, integerMap.get(subStr) - 1);
                wordMatchCount++;
            } else {
                break;
            }
        }
        return wordMatchCount == wordsSize;
    }
}
