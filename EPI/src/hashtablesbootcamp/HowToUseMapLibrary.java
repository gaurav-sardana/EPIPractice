package hashtablesbootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowToUseMapLibrary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// program to group the strings from the string array having anagrams
	// properties.
	// brute force is sort the string and compare with all the other string to check
	// each character giving the time complexity of
	// O(n^2m log m) n is the number of strings and m is maximum string length.

	// Another Solution with time O(mn logm) = Sorting all string(O(mn logm)) +
	// insertion ( O(log m));
	// Sort the string and add the string to Hash Map as key and value the List of
	// actual string

	public static List<List<String>> sortedStringsToAnagram(List<String> dictionary) {
		Map<String, List<String>> sortedStringsToAnagram = new HashMap<String, List<String>>();

		for (String s : dictionary) {
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			String str = new String(charArray);
			if (!sortedStringsToAnagram.containsKey(str)) {
				sortedStringsToAnagram.put(str, new ArrayList<String>());
			}
			sortedStringsToAnagram.get(str).add(s);
		}
		List<List<String>> groupsOfAnagram = new ArrayList<List<String>>();

		for (Map.Entry<String, List<String>> entry : sortedStringsToAnagram.entrySet()) {
			if (entry.getValue().size() >= 2) {
				groupsOfAnagram.add(entry.getValue());
			}
		}

		return groupsOfAnagram;
	}

}
