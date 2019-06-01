package arraybootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Problem11SampleOfflineData {

	public static void main(String[] args) {
		List<Integer> values = new ArrayList<Integer>(Arrays.asList(3,5,7,11));
		System.out.println(values.toString());
		for(int i=0;i<24;i++) {
			randomSampling(3, values);
			System.out.println(values.subList(0, 3).toString());
		}
	}

	public static void randomSampling(int k , List<Integer> integers) {
		Random random = new Random();
		for(int i=0;i <k;i++) {
			Collections.swap(integers, i, i+ random.nextInt(integers.size() -i));
		}
	}

}
