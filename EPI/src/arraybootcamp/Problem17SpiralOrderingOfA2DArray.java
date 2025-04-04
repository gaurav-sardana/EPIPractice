package arraybootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem17SpiralOrderingOfA2DArray {

    public static void main(String[] args) {
        List<Integer> spiralOrder = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)),
                new ArrayList<Integer>(Arrays.asList(12, 13, 14, 5)),
                new ArrayList<Integer>(Arrays.asList(11, 16, 15, 6)),
                new ArrayList<Integer>(Arrays.asList(10, 9, 8, 7))));
        spiralOrder(list, spiralOrder);
        System.out.println(spiralOrder.toString());
    }

    public static void spiralOrder(List<List<Integer>> twoDArray, List<Integer> spiralOrder) {
        		int startRow = 0,
                endRow = twoDArray.size() - 1,
                startColumn = 0,
				endColumm = twoDArray.size() - 1,
				dir = 0;


        while (startRow <= endRow && startColumn <= endColumm) {
            if (dir == 0) {
                for (int i = startRow; i <= endColumm; i++) {
                    spiralOrder.add(twoDArray.get(startRow).get(i));
                }
                startRow++;
                dir = 1;
            }
            if (dir == 1) {
                for (int i = startRow; i <= endColumm; i++) {
                    spiralOrder.add(twoDArray.get(i).get(endColumm));
                }
                endColumm--;
                dir = 2;
            }
            if (dir == 2) {
                for (int i = endColumm; i >= startColumn; i--) {
                    spiralOrder.add(twoDArray.get(endRow).get(i));
                }
                endRow--;
                dir = 3;
            }
            if (dir == 3) {
                for (int i = endRow; i >= startRow; i--) {
                    spiralOrder.add(twoDArray.get(i).get(startColumn));
                }
                startColumn++;
                dir = 0;
            }
        }
    }
}
