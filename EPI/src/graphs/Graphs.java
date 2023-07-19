package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gauravsardana
 * @since 25/09/21
 */
public class Graphs {
    public static class Edge {
        int nbr; // neighbour

        int wt; // weight

        public Edge(int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;
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
