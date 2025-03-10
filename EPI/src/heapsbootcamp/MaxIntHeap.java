package heapsbootcamp;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxIntHeap {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(20);
        minHeap.add(5);
        minHeap.add(40);

        System.out.println("Min Heap: " + minHeap); // Internal representation
        minHeap.add(1);
        System.out.println("Min Heap: " + minHeap); // Internal representation
        System.out.println("Min Heap Poll (smallest element): " + minHeap.poll());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(5);

        System.out.println("Max Heap: " + maxHeap);
        System.out.println("Max Heap Poll (largest element): " + maxHeap.poll()); // Removes 30
        System.out.println("Max Heap: " + maxHeap);



    }

}
