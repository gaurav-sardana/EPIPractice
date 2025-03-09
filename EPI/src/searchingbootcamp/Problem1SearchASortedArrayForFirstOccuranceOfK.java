package searchingbootcamp;

import java.util.Arrays;
import java.util.List;

public class Problem1SearchASortedArrayForFirstOccuranceOfK {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401);
		System.out.println(searchFirstOfK(list, 285));
		System.out.println(searchLastOfK(list, 285));

	}

	// time complexity is O(log n);
	public static int searchFirstOfK(List<Integer> A, int k) {

		int left = 0, right = A.size() - 1, result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A.get(mid) > k) {
				right = mid - 1;
			} else if (A.get(mid) == k) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return result;
	}

	public static int searchLastOfK(List<Integer> A, int k){
		int start = 0, end = A.size()-1, result = -1;

		while(start<= end){
			int mid = start + (end -start)/2;
			if(A.get(mid) < k){
				start = mid +1;
			}else if (A.get(mid) == k){
				result = mid;
				start = mid+1;
			}else{
				end = mid -1;
			}
		}
		return result;
	}
}
