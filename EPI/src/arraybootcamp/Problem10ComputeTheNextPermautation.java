package arraybootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem10ComputeTheNextPermautation {

	public static void main(String[] args) {
		List<Integer> permutation = new ArrayList<Integer>(Arrays.asList(6,2,1,5,4,3,0));
		System.out.println(permutation.toString());
		List<Integer> nextPermutation = getNextPermu(permutation);
		System.out.println(nextPermutation.toString());
	}

	public static List<Integer> getNextPermu(List<Integer> permu){
		int i=permu.size()-2;
		while(i>=0 && permu.get(i) >= permu.get(i+1)) {
			i--;
		}
		
		if(i == -1) {
			return Collections.emptyList();
		}
		
		for(int k= permu.size()-1; k>i ; k--) {
			if(permu.get(k) > permu.get(i)) {
				Collections.swap(permu, k, i);
				break;
			}
		}
		
		//revrese the subarray
		Collections.reverse(permu.subList(i+1, permu.size()));
		return permu;
	}
}
