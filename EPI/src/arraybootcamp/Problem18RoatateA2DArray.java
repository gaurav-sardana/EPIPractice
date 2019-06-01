package arraybootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18RoatateA2DArray {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1,2,3,4)),
				new ArrayList<Integer>(Arrays.asList(12,13,14,5)),
				new ArrayList<Integer>(Arrays.asList(11,16,15,6)),
				new ArrayList<Integer>(Arrays.asList(10,9,8,7))));
		print2DArray(list);
		rotate2D(list);
		System.out.println();
		System.out.println();
		print2DArray(list);
		
	}

	public static void rotate2D(List<List<Integer>> array2D) {
		
		final int matrixSize = array2D.size()-1;
		for(int i=0;i< array2D.size()/2 ;i++) {
			for(int j = i;j<matrixSize-i;j++) {
				
				int temp1 = array2D.get(matrixSize-j).get(i);
				int temp2 = array2D.get(matrixSize-i).get(matrixSize-j);
				int temp3 = array2D.get(j).get(matrixSize-i);
				int temp4 = array2D.get(i).get(j);
				
				array2D.get(i).set(j, temp1);
				array2D.get(matrixSize-j).set(i, temp2);
				array2D.get(matrixSize-i).set(matrixSize-j,temp3);
				array2D.get(j).set(matrixSize-i, temp4);
			}
		}
		
		
	} 
	public static void print2DArray(List<List<Integer>> arr) {
		for(List<Integer> a : arr) {
			for(Integer k : a) {
				System.out.print(k + "     ");
			}
			System.out.println();
		}
	}
}
