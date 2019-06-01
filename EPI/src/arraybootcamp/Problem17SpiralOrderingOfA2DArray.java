package arraybootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem17SpiralOrderingOfA2DArray {

	public static void main(String[] args) {
		List<Integer> spiralOrder = new ArrayList<Integer>();
		List<List<Integer>> list = new ArrayList<List<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1,2,3,4)),
				new ArrayList<Integer>(Arrays.asList(12,13,14,5)),
				new ArrayList<Integer>(Arrays.asList(11,16,15,6)),
				new ArrayList<Integer>(Arrays.asList(10,9,8,7))));
		spiralOrder(list,spiralOrder);
		System.out.println(spiralOrder.toString());
	}

	public static void spiralOrder(List<List<Integer>> twoDArray,List<Integer> spiralOrder) {
		int t=0 , b=twoDArray.size()-1,l=0,r = twoDArray.size()-1, dir=0;
		while(t<=b && l<=r) {
			if(dir == 0) {
				for(int i=t ; i<=r ;i++) {
					spiralOrder.add(twoDArray.get(t).get(i));
				}
				t++; dir=1;
			}
			if(dir==1) {
				for(int i=t ;i<=r;i++) {
					spiralOrder.add(twoDArray.get(i).get(r));
				}
				r--;dir=2;
			}
			if(dir==2) {
				for(int i=r;i>=l;i--) {
					spiralOrder.add(twoDArray.get(b).get(i));
				}
				b--;dir=3;
			}
			if(dir==3) {
				for(int i=b;i>=t;i--) {
					spiralOrder.add(twoDArray.get(i).get(l));
				}
				l++;dir=0;
			}
		}
	}
}
