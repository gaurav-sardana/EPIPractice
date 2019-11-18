package heapsbootcamp;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem6ComputeTheKlargestElementsInAMax_Heap {

	private static final Integer DEFAULT_INITIAL_CAPACITY = 16;

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(561, 314, 401, 28, 156, 359, 271, 11, 3);
		System.out.println(kLargestInBinaryHeap(list, 4));
	}

	// The total number of insertion and extract-max operations is 0(k), yielding an
	// O(k log k) time complexity
	// additional space complexity O(k)
	public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {

		if (k <= 0) {
			return Collections.emptyList();
		} else if (k > A.size()) {
			throw new IllegalStateException("k cannot be greater than A's size");
		}
		PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY,
				Compare.COMPARE_HEAP_ENTRIES);

		candidateMaxHeap.add(new HeapEntry(0, A.get(0)));
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			Integer index = candidateMaxHeap.peek().index;
			result.add(candidateMaxHeap.remove().value);

			Integer leftIndex = index * 2 + 1;
			if (leftIndex < A.size()) {
				candidateMaxHeap.add(new HeapEntry(leftIndex, A.get(leftIndex)));
			}
			Integer rightIndex = index * 2 + 2;
			if (rightIndex < A.size()) {
				candidateMaxHeap.add(new HeapEntry(rightIndex, A.get(rightIndex)));
			}

		}

		return result;
	}

}

class HeapEntry {
	public Integer index;
	public Integer value;

	public HeapEntry(Integer index, Integer value) {
		this.index = index;
		this.value = value;
	}
}

class Compare implements Comparator<HeapEntry> {

	public static final Compare COMPARE_HEAP_ENTRIES = new Compare();

	@Override
	public int compare(HeapEntry o1, HeapEntry o2) {
		return Integer.compare(o2.value, o1.value);
	}

}