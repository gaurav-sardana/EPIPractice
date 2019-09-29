package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Problem9ImplementAQueueUsingStacks {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(60);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
	}

	//takes O(m) time for m operations
	public static class Queue {

		Deque<Integer> enqueue = new LinkedList<Integer>();
		Deque<Integer> dequeue = new LinkedList<Integer>();

		public void enqueue(Integer integer) {
			enqueue.addFirst(integer);
		}

		public Integer dequeue() {
			if (dequeue.isEmpty()) {
				while(!enqueue.isEmpty()) {
					dequeue.addFirst(enqueue.removeFirst());
				}
			}
			
			if(!dequeue.isEmpty()) {
				return dequeue.removeFirst();
			}

			throw new NoSuchElementException("Cannot dequeue an empty Queue");
		}

	}

}
