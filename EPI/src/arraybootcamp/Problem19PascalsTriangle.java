package arraybootcamp;

public class Problem19PascalsTriangle {

	
	
	public static void main(String[] args) {
		int[][] triangle = getPascalstriangle(8);
		for(int i=0 ; i<triangle.length;i++) {
			for(int k=i;k<triangle.length;k++) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print(triangle[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	//Way 1
	public static int[][]getPascalstriangle(int height){
		
		int[][] pTriangle = new int[height][];
		for(int i=0 ; i<pTriangle.length ;i ++) {
			pTriangle[i] = new int[i+1];
		}
		
		pTriangle[0][0] = 1;
		
		for(int i=1 ;i <pTriangle.length ;i++) {
			for(int j=0 ; j<=i; j++) {
				if(j==0 || j==i) {
					pTriangle[i][j] = 1;
				}else {
					pTriangle[i][j] = pTriangle[i-1][j-1] + pTriangle[i-1][j];
				}
			}
		}
		// time complexity : O(1+2+3+3+....n) -> O(n(n+1/2)) ~ O(n^2)
		// space complexity O(n^2)
		return pTriangle;
	}
	
	//Way Book same 
	
	//try variant with O(n) space 
	public static int[][] getPascal(int height){
		return null;
	}

}
