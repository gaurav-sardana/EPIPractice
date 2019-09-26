package stacksandqueuesbootcamp;

import java.util.Arrays;
import java.util.Collections;

public class Problem8ImplementACircularQueue {

	public static void main(String[] args) {
		CyclicQueue cyclicQueue = new CyclicQueue(5);
		cyclicQueue.enqueue(1);
		cyclicQueue.enqueue(2);
		cyclicQueue.enqueue(3);
		cyclicQueue.enqueue(4);
		cyclicQueue.enqueue(5);
		System.out.println(cyclicQueue.dequeue());
		System.out.println(cyclicQueue.dequeue());
		System.out.println(cyclicQueue.dequeue());
		cyclicQueue.enqueue(1);
		cyclicQueue.enqueue(2);
		cyclicQueue.enqueue(3);
		System.out.println(cyclicQueue.dequeue());
		System.out.println(cyclicQueue.size());
		
	}

}

class CyclicQueue {

	private Integer[] queue;
	private int head = 0, tail = 0, size = 0;
	private static final int SCALE = 2;

	public CyclicQueue(int capacity) {
		queue = new Integer[capacity];
	}

	// O(1) time
	public void enqueue(Integer value) {
		if (size == queue.length) {
			Collections.rotate(Arrays.asList(queue), -head);
			head = 0;
			tail = size;
			queue = Arrays.copyOf(queue, SCALE * size);

		}
		queue[tail] = value;
		tail = (tail + 1) % queue.length;
		++size;

	}

	//O(1) time
	public Integer dequeue() {
		if (size != 0) {
			size--;
			Integer valueToReturn = queue[head];
			head = (head + 1) % queue.length;
			return valueToReturn;
		}
		throw new IllegalArgumentException("No element left to dequeue");
	}
	public Integer size() {
		return this.size;
	}

}
