package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Problem10ImplementAQueueWithMaxAPI {

	public static void main(String[] args) {

		QueueWithMaxReductionPattern max1 = new QueueWithMaxReductionPattern();
		max1.enqueue(3);
		max1.enqueue(1);
		max1.enqueue(3);
		max1.enqueue(2);
		max1.enqueue(1);
		max1.enqueue(0);
		max1.enqueue(4);
		max1.dequeue();
		max1.dequeue();
		max1.dequeue();
		max1.dequeue();
		max1.dequeue();
		max1.dequeue();
		System.out.println(max1.dequeue());
	}

	public static class QueueWithMax1<T extends Comparable<T>> {

		private Queue<T> entries = new LinkedList<>();
		private Deque<T> candidatesForMax = new LinkedList<>();

		// amortized time O(n)
		public void enqueue(T ele) {
			entries.add(ele);

			while (!candidatesForMax.isEmpty()) {
				int compareTo = candidatesForMax.getLast().compareTo(ele);
				if (compareTo >= 0) {
					break;
				}
				candidatesForMax.removeLast();
			}
			candidatesForMax.addLast(ele);
		}

		// time O(1) but amortized time O(n)
		public T dequeue() {
			if (!entries.isEmpty()) {
				T remove = entries.remove();
				if (remove.equals(candidatesForMax.getFirst())) {
					candidatesForMax.remove();
				}
				return remove;
			}

			throw new NoSuchElementException("queue is empty!");
		}

		// time O(1)
		public T max() {
			if (!candidatesForMax.isEmpty()) {
				return candidatesForMax.peek();
			}
			throw new NoSuchElementException("queue is empty!");
		}
	}

	// this approach have 0(1) amortized time complexity for enqueue, dequeue, and max.
	private static class QueueWithMaxReductionPattern {

		private Problem1ImplementAStackWithMaxAPI.MyStack2 enqueue = new Problem1ImplementAStackWithMaxAPI.MyStack2();
		private Problem1ImplementAStackWithMaxAPI.MyStack2 dequeue = new Problem1ImplementAStackWithMaxAPI.MyStack2();

		public void enqueue(Integer x) {
			enqueue.push(x);
		}

		public Integer dequeue() {
			if (dequeue.empty()) {
				while (!enqueue.empty()) {
					dequeue.push(enqueue.pop());
				}
			}
			if (!dequeue.empty()) {
				return dequeue.pop();
			}
			throw new NoSuchElementException("No element is present in queue");
		}

		public Integer max() {
			if (!enqueue.empty()) {
				return dequeue.empty() ? enqueue.max() : Math.max(dequeue.max(), enqueue.max());
			}
			if (!dequeue.empty()) {
				return dequeue.max();
			}
			throw new NoSuchElementException("No element is present in queue");
		}
	}

}
