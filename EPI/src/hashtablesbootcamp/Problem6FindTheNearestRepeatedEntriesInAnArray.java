package hashtablesbootcamp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6FindTheNearestRepeatedEntriesInAnArray {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("All", "work", "and", "no", "play", "makes", "for", "no", "work", "no", "fun",
				"and", "no", "results");
		System.out.println(findNearestRepetition(list));
	}

	// time complexity is O(n) n is the number of elements in string and space
	// complexity is O(s) s is the distinct elements in array
	public static int findNearestRepetition(List<String> paragraph) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int nearestRepeatedDisatance = Integer.MAX_VALUE;
		for (int i = 0; i < paragraph.size(); i++) {
			if (map.containsKey(paragraph.get(i))) {
				nearestRepeatedDisatance = Math.min(i - map.get(paragraph.get(i)), nearestRepeatedDisatance);
			}
			map.put(paragraph.get(i), i);
		}

		return nearestRepeatedDisatance == Integer.MAX_VALUE ? -1 : nearestRepeatedDisatance;
	}

}
