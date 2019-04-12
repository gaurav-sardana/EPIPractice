package arraybootcamp;

public class Problem4AdvancingThroughAnArray {

	public static void main(String[] args) {
		int[] arr = {2,2,0,2,2,0,0,2};
		if(canReachEnd(arr)) {
			System.out.println("It can reach end!");
		}else {
			System.out.println("It cannot reach end!");
		}
	}
	public static boolean canReachEnd(int[] arr) {
		
		int maxSteps = 0, lastIndex = arr.length-1;
		for(int i=0;  i<=maxSteps && maxSteps < lastIndex ;i++ ) {
			maxSteps = Math.max(maxSteps, arr[i]+i);
		}
		return maxSteps >= lastIndex;
	}

}
