package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gauravsardana
 * @since 19/07/23
 */
public class BFSAndDFS {
    static int[] visited;

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 0, 0 }, { 0, 0, 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0 } };
        System.out.println("<<<------ BFS------->>>");
        for (int i = 1; i < matrix.length; i++) {
            BFS(matrix, i, matrix.length - 1);
            System.out.println();
        }
        visited = new int[matrix.length];
        System.out.println("<<<------ DFS------->>>");

        for (int i = 1; i < matrix.length; i++) {
            DFS(matrix, i, matrix.length - 1, visited);
            visited = new int[matrix.length];
            System.out.println();
        }

    }

    /*
     * traverse the Graph
     * */
    public static void BFS(int[][] G, int start, int n) {
        final Queue<Integer> queue = new LinkedList<>();
        final int[] visited = new int[G.length];
        visited[start] = 1;
        queue.offer(start);
        System.out.print(start + ", ");
        while (!queue.isEmpty()) {
            final Integer poll = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (G[poll][i] == 1 && visited[i] == 0) {
                    System.out.print(i + ", ");
                    visited[i] = 1;
                    queue.offer(i);
                }
            }
        }

    }

    public static void DFS(int[][] G, int start, int n, int[] visited) {
        if (visited[start] == 0) {
            visited[start] = 1;
            System.out.print(start + ", ");
            for (int i = 1; i <= n; i++) {
                if (G[start][i] == 1 && visited[i] == 0) {
                    DFS(G, i, n, visited);
                }
            }
        }

    }

}
