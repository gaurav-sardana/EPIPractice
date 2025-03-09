package searchingbootcamp;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class LC34_FirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        return null;
    }
}

//Step-by-Step Execution
//Binary Search Starts (left = 0, right = 7, mid = 3)
//
//arr[3] = 6, which is greater than 3, so search left (right = 2).
//Next Iteration (left = 0, right = 2, mid = 1)
//
//arr[1] = 1, which matches 1, so we store 1 and search both sides.
//Left Search from left = 0, right = 0, mid = 0
//
//arr[0] = 1 is not a match (0 != 1), so stop searching left.
//Right Search from left = 2, right = 2, mid = 2
//
//arr[2] = 1 is not a match (2 != 1), so stop searching right.
//Returning to Initial Search, Right Search on left = 4, right = 7
//
//mid = 5, arr[5] = 6, so search left (right = 4).
//        Next Iteration, mid = 4
//
//arr[4] = 6, so search left (right = 3) → already checked.
//        Final Iteration, mid = 7
//
//arr[7] = 7 matches, so store 7.