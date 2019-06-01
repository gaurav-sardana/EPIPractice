package arraybootcamp;

import java.util.ArrayList;
import java.util.List;

public class Problem13ComputeARandomPermutation {

	public static void main(String[] args) {

		for(int i = 0;i<10;i++) {
			System.out.println(computeRandomPermu(7).toString());
		}
	}

	public  static List<Integer>  computeRandomPermu(int n) {
		List<Integer> integers = new ArrayList<Integer>();
		for(int i=0; i<n ;i++) {
			integers.add(i);
		}
		Problem11SampleOfflineData.randomSampling(integers.size(), integers);
		return integers;
	}
}
