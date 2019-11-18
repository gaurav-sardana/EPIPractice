package searchingbootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {

		Student student = new Student("Gaurav", 10.09);
		Student student2 = new Student("Harsh", 11.09);
		Student student3 = new Student("Divam", 10.09);
		List<Student> students = Arrays.asList(student, student2, student3);
		Collections.sort(students, Student.temp);
		int binarySearch = Collections.binarySearch(students, student2, Student.temp);
		System.out.println(students.get(binarySearch));
		for (Student s1 : students) {
			System.out.println(s1.toString());
		}
	}

	public static int binarySearch(int valueToBeFound, ArrayList<Integer> items) {

		int start = 0, end = items.size() - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2; // or (start+end/2) >>>1
			if (items.get(mid) < valueToBeFound) {
				end = mid - 1;
			} else if (items.get(mid) == valueToBeFound) {
				return mid;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}

class Student {
	public String name;
	public double gradePointAverage;
	public final static Comparator<Student> temp = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			if (o1.gradePointAverage != o2.gradePointAverage) {
				return Double.compare(o1.gradePointAverage, o2.gradePointAverage);
			}
			return o1.name.compareTo(o2.name);
		}
	};

	@Override
	public String toString() {
		return "[" + name + "," + gradePointAverage + "]";
	}

	public Student(String name, double gradePointAverage) {
		super();
		this.name = name;
		this.gradePointAverage = gradePointAverage;
	}

}
