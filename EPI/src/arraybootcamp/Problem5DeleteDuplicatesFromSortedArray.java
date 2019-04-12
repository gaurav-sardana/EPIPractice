package arraybootcamp;

import java.util.Arrays;

public class Problem5DeleteDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3,4,5,5,8,8,8,9,9,9};
		arr=deleteDuplicates(arr);
		EvenOdd.printArray(arr);
	}
	public static int[]  deleteDuplicates(int[] arr) {
		int newLength=1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]!=arr[i-1]) {
				arr[newLength++]= arr[i];
			}
		}
		return Arrays.copyOfRange(arr, 0, newLength);
	}
}
