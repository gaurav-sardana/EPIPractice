package heapsbootcamp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem3SortAnAlmost_SortedArray {

	public static void main(String[] args) {

		List<Integer> sequences = Arrays.asList(3, -1, 2, 6, 4, 5, 8);
		sortApproximatelySortedData(sequences.iterator(), 2);
	}

	// time complexity O(n log k) and space complexity O(k);
	public static void sortApproximatelySortedData(Iterator<Integer> sequence, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

//		Add the first k elements into min heap. Stop if there are fewer than k elements.
		for (int i = 0; i < k && sequence.hasNext(); i++) {
			minHeap.add(sequence.next());
		}

		// For every new element, add it to minHeap and extract the smallest.
		while (sequence.hasNext()) {
			minHeap.add(sequence.next());
			Integer smallest = minHeap.poll();
			System.out.println(smallest);
		}

		// sequence is exhausted, iteratively extract the remaining elements.
		while (!minHeap.isEmpty()) {
			Integer smallest = minHeap.poll();
			System.out.println(smallest);
		}
	}

}
