package hashtablesbootcamp;

import java.util.LinkedHashMap;

public class Problem3LRUImplementation {

	private static final int MAX = 6;

	public static void main(String[] args) {

	}

}

// time complexity is O(1) for hash Table look up and O(1) for updating the queue, i.e. O(1)
class LRUCache {
	private LinkedHashMap<Integer, Integer> isbnToPrice;

	public LRUCache(int capacity) {
		isbnToPrice = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public Integer lookup(Integer key) {
		if (!isbnToPrice.containsKey(key)) {
			return null;
		}
		return isbnToPrice.get(key);

	}

	public Integer insert(Integer key, Integer value) {
		Integer currentValue = isbnToPrice.get(key);
		if (!isbnToPrice.containsKey(key)) {
			isbnToPrice.put(key, value);
			return currentValue;
		} else {
			return null;
		}
	}

	public Integer remove(Object key) {
		return isbnToPrice.remove(key);
		// here it will make the value mapped to key NIL(null) but not remove it because
		// while look up they will continue after seeing the value mapped is nIL
	}

}
