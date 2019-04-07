package arraybootcamp;

import java.util.ArrayList;
import java.util.List;

public class Problem2IncreaseInArbitaryPrecisionInteger {

	public static void main(String[] args) {
//	 int[] arr = {9,9,9,9,7};
//	 arr = increaseInArbitaryPrecisionInteger(arr);
//		EvenOdd.printArray(arr);
		List<Integer> plusOneList = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(9);
		list.add(9);
		plusOneList=plusOneInArray(list);
		printList(plusOneList);
		
		
	}
	//time complexity is 0(n)
	public static List<Integer> plusOneInArray(List<Integer> intArray){
		int n = intArray.size()-1;
		intArray.set(n, intArray.get(n)+1);
		for(int i =n;i>0 && intArray.get(i)==10;i--) {
			intArray.set(i, 0);
			intArray.set(i-1, intArray.get(i-1)+1);
		}
		if(intArray.get(0)==10) {
			//shift the elements of array list
			intArray.set(0, 0);
			intArray.add(0, 1);
		}
		return intArray;
	}
	public static void printList(List<Integer> list) {
		for(Integer integer : list) {
			System.out.print(integer+" ");
		}
		System.out.println();
	} 
	/* my logic */
//	public static int[] increaseInArbitaryPrecisionInteger(int[] arr) {
//		arr[arr.length-1]+=1;
//		int rem=0;
//		int div =0;
//		for(int i=arr.length-1 ; i>=0;i--) {
//			arr[i]+=div;
//			div = arr[i]/10;
//			if(div>0) {
//				rem = arr[i]%10;
//				arr[i]=rem;
//				if(i==0) {
//					arr=shiftArryBy1(arr);
//					arr[0] = div;
//				}
//			}else {
//				break;
//			}
//		}
//		return arr;
//	}
//	public static int[] shiftArryBy1(int[] arr) {
//		int [] arr1 = new int[arr.length+1];
//		int start=arr.length;
//		while(start>0) {
//			arr1[start] = arr[start-1];
//			start--;
//		}
//		return arr1;
//	}

}
