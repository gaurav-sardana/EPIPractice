package arraybootcamp;

public class EvenOdd {

	public static void main(String[] args) {
		
		//make the array as all even values first and odd lasts
		int[] arr = {25,75,14,25,0,2,89,22};
		printArray(arr);
		evenOdd(arr);
		printArray(arr);

	}
	public static void printArray(int[] arr) {
		for(int a : arr) {
			System.out.print(a+"  ");
		}
		System.out.println();
	}
	public static void evenOdd(int[] arr) {
		
		int nexteven =0 , nextOdd = arr.length -1;
		while(nexteven <nextOdd) {
			if(arr[nexteven]%2==0) {
				nexteven++;
			}else {
				int temp = arr[nexteven];
				arr[nexteven] = arr[nextOdd];
				arr[nextOdd--] = temp;
			}
		}
	}

}
