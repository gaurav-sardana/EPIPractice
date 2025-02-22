package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author gauravsardana
 * @since 20/02/25
 */
public class DijkstraShortestDistance {
    public static void main(String[] args) {
        int V = 6;
        List<List<Graphs.Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());

        }

        graph.get(1).add(new Graphs.Edge(2, 50));
        graph.get(1).add(new Graphs.Edge(4, 10));
        graph.get(1).add(new Graphs.Edge(3, 45));
        graph.get(2).add(new Graphs.Edge(3, 10));
        graph.get(2).add(new Graphs.Edge(4, 15));
        graph.get(3).add(new Graphs.Edge(5, 30));
        graph.get(4).add(new Graphs.Edge(1, 10));
        graph.get(4).add(new Graphs.Edge(5, 15));
        graph.get(5).add(new Graphs.Edge(2, 20));
        graph.get(5).add(new Graphs.Edge(3, 35));
        graph.get(6).add(new Graphs.Edge(5, 3));

        int source = 1;
        int[] distances = dijkstra(graph, source);

        System.out.println("Vertex\tDistance from Source " + source);
        for (int i = 1; i < distances.length; i++) {
            System.out.println(i + "\t" + distances[i]);
        }
    }

    public static int[] dijkstra(List<List<Graphs.Edge>> edges, int source) {

        int[] distance = new int[edges.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        Queue<Graphs.Node> nodeQueue = new PriorityQueue<>();
        nodeQueue.add(new Graphs.Node(source, 0));
        while (!nodeQueue.isEmpty()) {
            final Graphs.Node current = nodeQueue.poll();
            final int u = current.vertex;
            for (Graphs.Edge edge : edges.get(u)) {
                final int v = edge.destination;
                final int weight = edge.wt;
                if (distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    nodeQueue.add(new Graphs.Node(v, distance[v]));
                }

            }
        }
        return distance;

    }
}
