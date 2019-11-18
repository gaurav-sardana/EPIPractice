package heapsbootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1MergeSortedFiles {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(3);
		list1.add(5);
		list1.add(7);
		List<Integer> list2 = new ArrayList<>();
		list2.add(0);
		list2.add(6);
		List<Integer> list3 = new ArrayList<>();
		list3.add(0);
		list3.add(6);
		list3.add(28);
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		List<Integer> mergeSortedArray = mergeSortedArray(lists);
		System.out.println(mergeSortedArray);

	}

	// time complexity O(n logk)
	public static List<Integer> mergeSortedArray(List<List<Integer>> sortedArrays) {

		List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
		for (List<Integer> array : sortedArrays) {
			iters.add(array.iterator());
		}

		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(), new Comparator<ArrayEntry>() {

			@Override
			public int compare(ArrayEntry o1, ArrayEntry o2) {
				return Integer.compare(o1.value, o2.value);
			}
		});

		for (int i = 0; i < iters.size(); i++) {
			minHeap.add(new ArrayEntry(iters.get(i).next(), i));
		}

		List<Integer> result = new ArrayList<Integer>();
		while (!minHeap.isEmpty()) {

			ArrayEntry poll = minHeap.poll();
			result.add(poll.value);
			if (iters.get(poll.arrayId).hasNext()) {
				minHeap.add(new ArrayEntry(iters.get(poll.arrayId).next(), poll.arrayId));
			}
		}
		return result;
	}

	public static List<String> topK(int k, Iterator<String> iter) {

		PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}

		});
		while (iter.hasNext()) {
			minHeap.add(iter.next());
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		return new ArrayList<>(minHeap);
	}

}

class ArrayEntry {
	public Integer value;
	public Integer arrayId;

	public ArrayEntry(Integer value, Integer arrayId) {
		this.value = value;
		this.arrayId = arrayId;
	}

}
