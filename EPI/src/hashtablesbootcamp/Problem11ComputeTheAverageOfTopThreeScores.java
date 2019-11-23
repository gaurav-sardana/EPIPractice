package hashtablesbootcamp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem11ComputeTheAverageOfTopThreeScores {

	public static void main(String[] args) {

	}

	
	public static String findStudentWithHighestBestOfThreeScroes(Iterator<Object> nameScoreData) {
		Map<String, PriorityQueue<Integer>> studentScores = new HashMap<String, PriorityQueue<Integer>>();
		while (nameScoreData.hasNext()) {
			String studentName = (String) nameScoreData.next();
			Integer studentScore = (Integer) nameScoreData.next();
			PriorityQueue<Integer> scores = studentScores.get(studentName);
			if (scores == null) {
				scores = new PriorityQueue<Integer>();
				studentScores.put(studentName, scores);
			}
			scores.add(studentScore);
			if (scores.size() > 3) {
				scores.poll();
			}
		}

		String topStudent = "No Top Student Found";
		int maximumMarks = 0;
		for (Map.Entry<String, PriorityQueue<Integer>> student : studentScores.entrySet()) {
			if (student.getValue().size() == 3) {
				int totalMarks = getTotalMarks(student.getValue().iterator());
				if (totalMarks > maximumMarks) {
					topStudent = student.getKey();
					maximumMarks = totalMarks;
				}
			}
		}

		return topStudent;

	}

	public static int getTotalMarks(Iterator<Integer> iterator) {
		int total = 0;
		while (iterator.hasNext()) {
			total += iterator.next();
		}
		return total;
	}

}
