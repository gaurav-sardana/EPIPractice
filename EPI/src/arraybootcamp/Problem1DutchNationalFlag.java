package arraybootcamp;

public class Problem1DutchNationalFlag {

	public static void main(String[] args) {
		int arr[] = {1,2,0,1,2,0,0,2,1};
		quickSort(arr,0);
		EvenOdd.printArray(arr);
		
	}
	
	
	
//	 bad logic// space O(1) ann Time O(n)
//	public static void quickSort(int arr[], int pivotIndex) {
//		int pivot = arr[pivotIndex];
//		int smaller = -1;
//		for(int i=0;i<arr.length;i++) {
//			if(pivot>arr[i]) {
//				smaller++;
//				int temp = arr[i];
//				arr[i] = arr[smaller];
//				arr[smaller] = temp;
//			}
//		}
//		int higher = arr.length;
//		for(int i=arr.length-1;i>=0;i--) {
//			if(pivot<arr[i]) {
//				higher--;
//				int temp = arr[i];
//				arr[i] = arr[higher];
//				arr[higher] = temp;
//			}
//		}
//		
//	}
	
	//in a single phase everthing is sort time complexity is O(n) Space : O(1)
	public static void quickSort(int arr[], int pivotIndex) {
		int smaller = 0, equal =0, higher = arr.length;
		int pivot = arr[pivotIndex];
		while(equal < higher) {
			if(arr[equal]<pivot) {
				int temp = arr[equal];
				arr[equal] = arr[smaller];
				arr[smaller] = temp;
				smaller++;
				equal++;
			}else if(arr[equal] == pivot) {
				equal++;
			}else {
				higher--;
				int temp = arr[equal];
				arr[equal] = arr[higher];
				arr[higher] = temp;
			}
		}
	}
	

}

enum Color{
	RED,
	GREEN,
	BLUE;
}
