package hashtablesbootcamp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem10FindTheLongestOfTheLongestContainedInterval {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(3, -2, 7, 9, 8, 1, 2, 0, -1, 5, 8);
		System.out.println(longestContainedRange(integers));
	}

	// brute force algorithm is to sort the array and then iterate through it and
	// recording the largest subset O(n+ n log n)

	// optimal : we iterate over the array and record the element and check the
	// upper bounds and lower bounds of the element and remove the elements
	// accordingly, hence record the difference of the bounds higher - lower -1 and
	// store it as the maximum and accordingly
	// time complexity is O(n) n is the array length
	public static int longestContainedRange(List<Integer> A) {

		Set<Integer> unprocessedEntries = new HashSet<>(A);
		int maxIntervalSize = 0;
		while (!unprocessedEntries.isEmpty()) {
			Integer bound = unprocessedEntries.iterator().next();
			unprocessedEntries.remove(bound);
			int lowerBound = bound - 1;
			while (unprocessedEntries.contains(lowerBound)) {
				unprocessedEntries.remove(lowerBound);
				--lowerBound;
			}
			int upperBound = bound + 1;
			while (unprocessedEntries.contains(upperBound)) {
				unprocessedEntries.remove(upperBound);
				++upperBound;
			}

			maxIntervalSize = Math.max(maxIntervalSize, upperBound - lowerBound - 1);

		}
		return maxIntervalSize;
	}

}
