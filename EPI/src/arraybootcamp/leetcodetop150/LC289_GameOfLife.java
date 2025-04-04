package arraybootcamp.leetcodetop150;

import java.util.Arrays;

public class LC289_GameOfLife {
    public static void main(String[] args) {
        int[][] ints = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(ints);
    }

    public static void gameOfLife(int[][] board) {

        // create a copy of board;
        int rows = board.length;
        int cols = board[0].length;
        int[][] copyBoard = new int[rows][];

        int[] neighbours = new int[]{-1, 0, 1};

        for (int i = 0; i < rows; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {


                int oneCount = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbours[i] == 0 && neighbours[j] == 0)) {
                            int r = row + neighbours[i];
                            int c = col + neighbours[j];

                            if (r >= 0 && r < rows && c >= 0 && c < cols && copyBoard[r][c] == 1) oneCount++;
                        }

                    }

                }

                //rule 1 & 3
                if (board[row][col] == 1 && (oneCount < 2 || oneCount > 3)) {
                    board[row][col] = 0;
                }

                // rule 4
                if (board[row][col] == 0 && oneCount == 3) {
                    board[row][col] = 1;
                }


            }
        }


        // neighbor cells


    }
}
