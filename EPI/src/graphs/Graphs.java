package graphs;

import java.util.ArrayList;

/**
 * @author gauravsardana
 * @since 25/09/21
 */
public class Graphs {
    public static class Edge {
        int destination; // neighbour

        int wt; // weight

        public Edge(int destination, int wt) {
            this.destination = destination;
            this.wt = wt;
        }

    }

    public static class Node implements Comparable<Node> {
        int vertex; // neighbour

        int distance; // weight

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.distance, this.distance);
        }

    }

    public static void solve() {
        int n = 7;
        int[] arr = new int[2];

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (ArrayList<Edge> g : graph) {
            g = new ArrayList<>();
        }

    }

    public static void main(String[] args) {

    }

}
