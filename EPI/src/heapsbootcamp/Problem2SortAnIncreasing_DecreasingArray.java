package heapsbootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2SortAnIncreasing_DecreasingArray {

	private static enum SubarrayType {
		INCREASING, DECREASING
	}

	public static void main(String[] args) {
		List<Integer> incDecArray = Arrays.asList(57, 131, 493, 294, 221, 339, 418, 452, 442, 190);
		List<Integer> sortKIncreasingDecreasingArray = sortKIncreasingDecreasingArray(incDecArray);
		System.out.println(sortKIncreasingDecreasingArray);
	}

	public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {

		List<List<Integer>> sortedSubarrays = new ArrayList<>();
		SubarrayType type = SubarrayType.INCREASING;
		int startIdx = 0;

		for (int i = 1; i <= A.size(); i++) {
			if (i == A.size() || (A.get(i - 1) < A.get(i) && type == SubarrayType.DECREASING)
					|| (A.get(i - 1) >= A.get(i) && type == SubarrayType.INCREASING)) {

				List<Integer> subList = A.subList(startIdx, i);
				if (type == SubarrayType.DECREASING) {
					Collections.reverse(subList);
				}
				sortedSubarrays.add(subList);
				startIdx = i;
				type = (type == SubarrayType.INCREASING) ? SubarrayType.DECREASING : SubarrayType.INCREASING;
			}
		}

		return Problem1MergeSortedFiles.mergeSortedArray(sortedSubarrays);
	}

}
