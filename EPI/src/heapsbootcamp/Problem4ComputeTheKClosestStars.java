package heapsbootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem4ComputeTheKClosestStars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//time complexity is O(n log k) and the space complexity is O(k)
	public static List<Star> findClosestKStars(int k, Iterator<Star> stars) {
		PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

		while (stars.hasNext()) {
			maxHeap.add(stars.next());
			if (maxHeap.size() == k + 1) {
				maxHeap.remove();
			}
		}

		List<Star> orderedStars = new ArrayList<Star>(maxHeap);

		Collections.sort(orderedStars);
		return orderedStars;
	}

}

class Star implements Comparable<Star> {

	private double x, y, z;

	public Star(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double distance() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	@Override
	public int compareTo(Star o) {
		// TODO Auto-generated method stub
		return Double.compare(o.distance(), this.distance());
	}

}