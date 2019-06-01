package arraybootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem16SudokuCheckProblem {

public static void main(String[] args) {
		
		List <Integer> row1 = new ArrayList<Integer>(Arrays.asList(5,3,4,6,7,8,9,1,2));
		List <Integer> row2 = new ArrayList<Integer>(Arrays.asList(6,7,2,1,9,5,3,4,8));
		List <Integer> row3 = new ArrayList<Integer>(Arrays.asList(1,9,8,3,4,2,5,6,7));
		List <Integer> row4 = new ArrayList<Integer>(Arrays.asList(8,5,9,7,6,1,4,2,3));
		List <Integer> row5 = new ArrayList<Integer>(Arrays.asList(4,2,6,8,5,3,7,9,1));
		List <Integer> row6 = new ArrayList<Integer>(Arrays.asList(7,1,3,9,2,4,8,5,6));
		List <Integer> row7 = new ArrayList<Integer>(Arrays.asList(9,6,1,5,3,7,2,8,4));
		List <Integer> row8 = new ArrayList<Integer>(Arrays.asList(2,8,7,4,1,9,6,3,5));
		List <Integer> row9 = new ArrayList<Integer>(Arrays.asList(3,4,5,2,8,6,1,7,9));
		List<List<Integer>>  partialAssignment = new ArrayList<List<Integer>>(Arrays.asList(row1,row2,row3,row4,row5,row6,row7,row8,row9));

		System.out.println("The given Sudoku assignment is " + (isValisSudoku(partialAssignment) ? "valid till now " : "not valid")  );
		
	}

	public static boolean isValisSudoku(List<List<Integer>> sudoku) {


		for(int i = 0 ;i<sudoku.size();i++) {
			//for all rows
			if(hasDuplicate(sudoku, i, i+1, 0, sudoku.size())) {
				return false;
			}
			//for all columns
			if(hasDuplicate(sudoku, 0, sudoku.size(), i, i+1)) {
				return false;
			}
		}

		//for 3 x 3 regions

		int region = (int)Math.sqrt(sudoku.size());
		for(int i=0;i<region;i++) {
			for(int j=0;j<region;j++) {
				if(hasDuplicate(sudoku, i * region, (i+1) *  region, j * region, (j+1) *  region)) {
					return false;
				}
			}
		}

		return true;
	}

	// method is written in such a way that it will evaluate total 9 memory blocks containing values [1,9]
	//send in any form 9 x 1 ... or 3 x 3 or 1 x 9
	public static boolean hasDuplicate(List<List<Integer>> assignments,int startRow, int endRow , int startColumn, int endColumn) {
		List<Boolean> isPresent = new ArrayList<Boolean>(Collections.nCopies(assignments.size() +1, false));

		for(int i=startRow;i<endRow;i++) {
			for(int j=startColumn;j<endColumn;j++ ) {
				int value = assignments.get(i).get(j);
				if(value!=0  && isPresent.get(value)) {
					return true;
				}
				isPresent.set(value, true);
			}
		}
		return false;
	}

}
