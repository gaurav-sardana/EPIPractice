package hashtablesbootcamp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem9FindTheLongestSubArrayWithDistinctEntries {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(1, 2, 1, 3, 4, 5, 3, 6, 5, 3);
		System.out.println(longestSubArrayWithDistinctEntries(A));
	}

	// O(n) since we perform constant number of operations per element
	public static int longestSubArrayWithDistinctEntries(List<Integer> A) {

		Map<Integer, Integer> mostRecentOccurance = new HashMap<Integer, Integer>();
		int longestDuplicateFreeSubArrayStartIdx = 0, result = 0;
		for (int i = 0; i < A.size(); i++) {
			Integer duplicateValueIdx = mostRecentOccurance.put(A.get(i), i);
			if (duplicateValueIdx != null) {
				if (duplicateValueIdx >= longestDuplicateFreeSubArrayStartIdx) {
					result = Math.max(result, i - longestDuplicateFreeSubArrayStartIdx);
					longestDuplicateFreeSubArrayStartIdx = duplicateValueIdx + 1;
				}
			}
		}
		result = Math.max(result, A.size() - longestDuplicateFreeSubArrayStartIdx);
		return result;
	}

}
