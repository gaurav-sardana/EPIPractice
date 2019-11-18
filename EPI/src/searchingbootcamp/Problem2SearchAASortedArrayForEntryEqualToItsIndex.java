package searchingbootcamp;

import java.util.Arrays;
import java.util.List;

public class Problem2SearchAASortedArrayForEntryEqualToItsIndex {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401);
		System.out.println(searchEntryEqualToItsIndex(list));
	}

	// time complexity is O(log n)
	public static int searchEntryEqualToItsIndex(List<Integer> list) {
		int left = 0, right = list.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int diff = list.get(mid) - mid;
			if (diff > 0) {
				right = mid - 1;
			} else if (diff == 0) {
				return mid;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
