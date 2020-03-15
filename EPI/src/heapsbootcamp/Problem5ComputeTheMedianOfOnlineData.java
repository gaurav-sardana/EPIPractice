package heapsbootcamp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem5ComputeTheMedianOfOnlineData {
    private static final int DEFAULT_INITIAL_CPACITY = 16;

    public static void main(String[] args) {

        List<Integer> sequence = Arrays.asList(1, 0, 3, 5, 2, 0, 1);
        onlineMedian(sequence.iterator());
    }

    // time complexity per entry is O(log n)
    public static void onlineMedian(Iterator<Integer> sequence) {
        // stores larger half so far
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // stores smaller half so far
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CPACITY, Collections.reverseOrder());
        while (sequence.hasNext()) {
            int x = sequence.next();
            if (minHeap.isEmpty()) {
                // first element
                minHeap.add(x);
            } else {
                if (x >= minHeap.peek()) {
                    minHeap.add(x);
                } else {
                    maxHeap.add(x);
                }
            }

            // ensure maxHeap and minHeap have equal number of elements if an even number of
            // elements is read;
            // otherwise minHeap must have one more element than maxHeap.
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.remove());
            } else if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }
            final double onlineMedian = (maxHeap.size() == minHeap.size()) ? ((maxHeap.peek() + minHeap.peek()) * 0.5) : minHeap.peek();
            System.out.println(onlineMedian);
        }

    }

}
