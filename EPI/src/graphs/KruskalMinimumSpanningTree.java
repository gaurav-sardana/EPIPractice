package graphs;

import java.util.Arrays;

/**
 * @author gauravsardana
 * @since 30/07/23
 */
public class KruskalMinimumSpanningTree {
    public static void main(String[] args) {

        final int[][] costEdges = { { 1, 1, 2, 2, 3, 4, 4, 5, 5 }, { 2, 6, 3, 7, 4, 5, 7, 6, 7 }, { 25, 5, 12, 10, 8, 16, 14, 20, 18 } };
        final int[][] spanningTree = getSpanningTree(costEdges, 7);
        PrimsMinimumSpanningTree.printSpanningTree(spanningTree);
        System.out.println("Sum : " + sumSpanningTree(spanningTree, costEdges));

    }

    /**
     * [Repeating Steps]
     * 1. Find the minimum edge from the input (costEdges) which are not included(edgesIncluded)
     * 2. check if already included && check if cycle exists(find parent of vertices i.e. if equal means cycle exists else no cycle)
     * 3. if no cycle exists, add them in result edges
     * 4. perform weighted union on the select edge
     * 5. mark the selected edge as included
     */
    public static int[][] getSpanningTree(final int[][] costEdges, final int n) {
        int i = 0, u = 0, v = 0, k = -1, edgesLength = costEdges[0].length;
        final int[] setArray = new int[n + 1];
        Arrays.fill(setArray, -1);
        final int[] edgesIncluded = new int[edgesLength];
        Arrays.fill(edgesIncluded, 0);
        final int[][] resultEdges = new int[2][n - 1];
        while (i < n - 1) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < edgesLength; j++) {
                if (edgesIncluded[j] == 0 && costEdges[2][j] < min) {
                    min = costEdges[2][j];
                    u = costEdges[0][j];
                    v = costEdges[1][j];
                    k = j;
                }
            }
            if (collapsingFind(setArray, u) != collapsingFind(setArray, v)) {
                resultEdges[0][i] = u;
                resultEdges[1][i] = v;
                union(setArray, collapsingFind(setArray, u), collapsingFind(setArray, v));
                i++;
            }
            edgesIncluded[k] = 1;
        }
        return resultEdges;
    }

    public static int collapsingFind(final int[] setArray, final int u) {
        int x = u;
        while (setArray[x] > 0) {
            x = setArray[x];
        }
        return x;
    }

    public static void union(final int[] setArray, final int u, final int v) {
        if (setArray[u] < setArray[v]) {
            setArray[u] = setArray[u] + setArray[v];
            setArray[v] = u;
        } else {
            setArray[v] = setArray[v] + setArray[u];
            setArray[u] = v;
        }
    }

    public static int sumSpanningTree(final int[][] spanningTree, final int[][] costEdges) {
        int sum = 0;
        for (int i = 0; i < spanningTree[0].length; i++) {
            for (int j = 0; j < costEdges[0].length; j++) {
                if (costEdges[0][j] == spanningTree[0][i] && costEdges[1][j] == spanningTree[1][i]) {
                    sum += costEdges[2][j];
                }
            }
        }
        return sum;
    }
}
