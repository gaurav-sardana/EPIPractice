package graphs;

import java.util.*;

public class PrimsMSTLazy {
    public static void main(String[] args) {

        List<List<Graphs.Node2>> graph = new ArrayList<>();
        graph.add(null);
        graph.add(List.of(new Graphs.Node2(1, 6, 5), new Graphs.Node2(1, 2, 25)));
        graph.add(List.of(new Graphs.Node2(2, 1, 25), new Graphs.Node2(2, 7, 6), new Graphs.Node2(2, 3, 9)));
        graph.add(List.of(new Graphs.Node2(3, 2, 9), new Graphs.Node2(3, 4, 10)));
        graph.add(List.of(new Graphs.Node2(4, 3, 10), new Graphs.Node2(4, 5, 12)));
        graph.add(List.of(new Graphs.Node2(5, 4, 12), new Graphs.Node2(5, 7, 16), new Graphs.Node2(5, 6, 18)));
        graph.add(List.of(new Graphs.Node2(6, 5, 18), new Graphs.Node2(6, 1, 5)));
        graph.add(List.of(new Graphs.Node2(7, 5, 16), new Graphs.Node2(7, 4, 11), new Graphs.Node2(7, 2, 6)));

        System.out.println(shortestPath(graph, 1));
    }


    // n : no. of nodes in a graph
    // pg : min heap to store edges
    // g = adjacency list - sparse graph
    //     adjacency matrix - dense graph
    public static int shortestPath(List<List<Graphs.Node2>> graph, int source) {
        int edgesCount = graph.size() - 2;
        List<Graphs.Node2> nodes = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        int edgesEncounter = 0, mstCost = 0;
        PriorityQueue<Graphs.Node2> pq = new PriorityQueue<>();
        addEdges(graph, pq, visited, source);

        while (!pq.isEmpty()) {
            Graphs.Node2 currNode = pq.poll();
            if (visited.contains(currNode.destination)) {
                continue;
            }

            mstCost += currNode.distance;
            nodes.add(currNode);
            edgesEncounter++;
            addEdges(graph, pq, visited, currNode.destination);
        }

        if (edgesEncounter != edgesCount) {
            return -1;
        }
        System.out.println(nodes);

        return mstCost;
    }

    public static void addEdges(List<List<Graphs.Node2>> graph, PriorityQueue<Graphs.Node2> pq, Set<Integer> visited, int element) {
        List<Graphs.Node2> nodes = graph.get(element);
        visited.add(element);
        for (Graphs.Node2 node : nodes) {
            if (!visited.contains(node.destination)) {
                pq.offer(node);
            }
        }

    }
}
