package hashtablesbootcamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Problem1TestForPalindromicPermutations {

	public static void main(String[] args) {
		System.out.println(canFormPalindrome("HelleH"));
	}

// brute force : Take all the permutation of the string and check if the string is palindromic
	// Other solution is if there are pairs of char in the string and at most one
	// odd
	// then the string Permutation can be palindromic

	// time complexity is O(n) n is length of the string and space complexity is
	// O(c) c is the number of distinct characters
	public static boolean canFormPalindrome(String str) {

		Map<Character, Integer> charFrequencies = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			char charAt = str.charAt(i);
			if (!charFrequencies.containsKey(charAt)) {
				charFrequencies.put(charAt, 1);
			} else {
				charFrequencies.put(charAt, charFrequencies.get(charAt) + 1);
			}
		}

		int oddValues = 0;
		for (Entry<Character, Integer> p : charFrequencies.entrySet()) {
			if (p.getValue() % 2 != 0 && ++oddValues > 1) {
				return false;
			}
		}

		return true;
	}

}
