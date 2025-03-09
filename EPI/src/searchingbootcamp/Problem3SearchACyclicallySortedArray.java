package searchingbootcamp;

public class Problem3SearchACyclicallySortedArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-1, 2, 4, 4, 6}, {1, 5, 5, 9, 21}, {3, 6, 6, 9, 22}, {3, 6, 8, 10, 24}, {6, 8, 9, 12, 25}, {8, 10, 12, 13, 40}};
        System.out.println(matrixSearch(matrix, 7));
        System.out.println(matrixSearch(matrix, 8));

    }

    // for each iteration we remove a row or column, inspecting at most m+n-1 elements, O(m+n) time complexity
    public static boolean matrixSearch(int[][] matrix, int target) {


        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;

    }
}
