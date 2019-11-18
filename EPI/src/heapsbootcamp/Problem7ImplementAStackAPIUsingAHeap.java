package heapsbootcamp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem7ImplementAStackAPIUsingAHeap {

	public static void main(String[] args) {

	}

}

class ValueWithRank {
	public Integer value;
	public Integer rank;

	public ValueWithRank(Integer value, Integer rank) {
		super();
		this.value = value;
		this.rank = rank;

	}

}

class CompareRank implements Comparator<ValueWithRank> {
	public static final CompareRank COMPARE_VALUEWITHRANK = new CompareRank();

	@Override
	public int compare(ValueWithRank o1, ValueWithRank o2) {
		return Integer.compare(o2.rank, o1.rank);
	}

}

class Stack {
	private static final Integer DEFAULT_CAPACITY_SIZE = 16;
	private int timestamp = 0;
	private PriorityQueue<ValueWithRank> ranks = new PriorityQueue<>(DEFAULT_CAPACITY_SIZE,
			CompareRank.COMPARE_VALUEWITHRANK);

	public void push(Integer x) {
		ranks.add(new ValueWithRank(x, timestamp++));
	}

	public Integer pop() {
		return ranks.remove().value;
	}

	public Integer peek() {
		return ranks.peek().value;
	}
}
