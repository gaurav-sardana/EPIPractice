package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gauravsardana
 * @since 12/02/25
 */
public class LC_200_NumberOfIslands {
    private static int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    public static void main(String[] args) {
        char[][] value = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
        System.out.println(numIslands(value));

    }

    public static int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    result++;
                    grid[r][c] = 0;
                    //apply bfs
                    bfs(grid, r, c, m, n);
                }
            }
        }

        return result;
    }

    public static void bfs(char[][] grid, int r, int c, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { r, c });
        while (!queue.isEmpty()) {
            final int[] curr = queue.poll();
            for (int[] dir : dirs) {
                final int nr = curr[0] + dir[0];
                final int nc = curr[1] + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
    }
}
