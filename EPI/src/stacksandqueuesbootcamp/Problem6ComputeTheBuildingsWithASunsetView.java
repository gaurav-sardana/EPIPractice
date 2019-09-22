package stacksandqueuesbootcamp;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;


public class Problem6ComputeTheBuildingsWithASunsetView {

	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedList<Integer>();
		deque.addLast(5);
		deque.addLast(4);
		deque.addLast(3);
		deque.addLast(2);
		deque.addLast(1);
		deque.addLast(1);
		Iterator<Integer> iterator = deque.iterator();
		Deque<BuildingWithHeight> examineBuildingWithSunset = examineBuildingWithSunset(iterator);
		while(!examineBuildingWithSunset.isEmpty()) {
			System.out.println(examineBuildingWithSunset.removeFirst().height);
		}
	}
	
	public static Deque<BuildingWithHeight> examineBuildingWithSunset(Iterator<Integer> sequence) {
		
		Deque<BuildingWithHeight> buildingWithSunsets = new LinkedList<BuildingWithHeight>();
		int buildingIdx = 0;
		while(sequence.hasNext()) {
			Integer buildingHeight = sequence.next();
			while(!buildingWithSunsets.isEmpty() && Integer.compare(buildingHeight, buildingWithSunsets.getLast().height)>=0) {
				buildingWithSunsets.removeLast();
			}
			buildingWithSunsets.addLast(new BuildingWithHeight(buildingIdx++, buildingHeight));
		}
		
		return buildingWithSunsets;
	}

}

class BuildingWithHeight {
	public Integer id;
	public Integer height;

	public BuildingWithHeight(Integer id, Integer height) {
		this.id = id;
		this.height = height;
	}
}
