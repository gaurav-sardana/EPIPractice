package graphs;

/**
 * @since 22/07/23
 */
import static java.lang.Integer.MAX_VALUE;
import java.util.Arrays;

/**
 * Time Complexity (Analytical) :  (|V| - 1) . |E| ; n.e = n^2 =  O(n^2)
 * In case of using Heap Data Structure or  Red Black Tree : (|V| - 1) . log(E); n . log(n) = O(nlog(n))
 **/
public class PrimsMinimumSpanningTree {
    public static void main(String[] args) {
        int[][] costMatrix = { { MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE }, { MAX_VALUE, MAX_VALUE, 25, MAX_VALUE, MAX_VALUE, MAX_VALUE, 5, MAX_VALUE }, { MAX_VALUE, 25, MAX_VALUE, 12, MAX_VALUE, MAX_VALUE, MAX_VALUE, 10 }, { MAX_VALUE, MAX_VALUE, 12, MAX_VALUE, 8, MAX_VALUE, MAX_VALUE, MAX_VALUE }, { MAX_VALUE, MAX_VALUE, MAX_VALUE, 8, MAX_VALUE, 16, MAX_VALUE, 14 }, { MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, 16, MAX_VALUE, 20, 18 }, { MAX_VALUE, 5, MAX_VALUE, MAX_VALUE, MAX_VALUE, 20, MAX_VALUE, MAX_VALUE }, { MAX_VALUE, MAX_VALUE, 10, MAX_VALUE, 14, 18, MAX_VALUE, MAX_VALUE }, };

        final int[][] spanningTree = getSpanningTree(costMatrix, costMatrix.length - 1);
        printSpanningTree(spanningTree);
        System.out.println("Sum : " + sumSpanningTree(spanningTree, costMatrix));
    }

    // Using cost adjacency matrix

    /**
     * 1. Find minimum cost edge; introduce edges array(2 x (N-1); here N is number of vertex, put minimum edge into edges, Hint : check upper/lower triangular part
     * 2. Introduce near array which represent all vertices with O for visited vertices, and
     * 3. Update the near array with nearest of minimum edge vertex found above ignoring already visited i.e. near[i] == 0,
     * 4. [Repeating Step]  Find minimum from near array and put into edges array and mark selected vertex as O
     * 5. [Repeating Step] introduce k which was the last connected vertex
     * 6. [Repeating Step] find next minimum connected vertex of k; iterate near and check for nearer and update the nearer
     */
    public static int[][] getSpanningTree(final int[][] costMatrix, final int n) {
        // Find minimum cost edge
        int[][] edges = new int[2][n - 1];
        int[] near = new int[n + 1];
        Arrays.fill(near, MAX_VALUE);
        int min = MAX_VALUE;
        int u = 0, v = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (costMatrix[i][j] < min) {
                    min = costMatrix[i][j];
                    u = i;
                    v = j;
                }
            }
        }
        near[u] = 0;
        near[v] = 0;
        edges[0][0] = u;
        edges[1][0] = v;

        for (int i = 1; i < near.length; i++) {
            if (near[i] != 0) {
                if (costMatrix[i][u] < costMatrix[i][v]) {
                    near[i] = u;
                } else {
                    near[i] = v;
                }
            }
        }
        for (int j = 1; j < n - 1; j++) {
            int minValue = MAX_VALUE;
            int point = 0;
            for (int k = 1; k < near.length; k++) {
                if (near[k] != 0 && costMatrix[k][near[k]] < minValue) {
                    minValue = costMatrix[k][near[k]];
                    point = k;
                }
            }
            edges[0][j] = point;
            edges[1][j] = near[point];
            near[point] = 0;

            for (int k = 1; k < near.length; k++) {
                if (near[k] != 0 && costMatrix[k][near[k]] > costMatrix[k][point]) {
                    near[k] = point;
                }
            }

        }

        return edges;

    }

    /**
     * Assuming spanning Tree is 2xN
     */
    public static void printSpanningTree(final int[][] spanningTree) {
        for (int i = 0; i < spanningTree[0].length; i++) {
            System.out.println("[" + spanningTree[0][i] + "," + spanningTree[1][i] + "]");
        }
    }

    /**
     * Assuming cost matrix is NxN
     */
    public static int sumSpanningTree(final int[][] spanningTree, final int[][] costMatrix) {
        int sum = 0;
        for (int i = 0; i < spanningTree[0].length; i++) {
            sum += costMatrix[spanningTree[0][i]][spanningTree[1][i]];
        }
        return sum;
    }
}
