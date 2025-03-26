package graphsbootcamp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneAGraph {

    private static Map<Integer, GraphVertex> map = new HashMap<Integer, GraphVertex>();

    public static void main(String[] args) {

    }

    public static GraphVertex clone(GraphVertex node) {
        if (node == null) return node;

        Map<GraphVertex, GraphVertex> graphVertexGraphVertexMap = new HashMap<>();

        Queue<GraphVertex> queue = new LinkedList<>();
        queue.add(node);
        graphVertexGraphVertexMap.put(node, new GraphVertex(node.field));
        while (!queue.isEmpty()) {
            GraphVertex graphVertex = queue.poll();

            for (GraphVertex vertex : graphVertex.graphVertices) {
                if (!graphVertexGraphVertexMap.containsKey(vertex)) {
                    graphVertexGraphVertexMap.put(vertex, new GraphVertex(vertex.field));
                    queue.add(vertex);
                }

                //copying the edges
                graphVertexGraphVertexMap.get(graphVertex).graphVertices.add(graphVertexGraphVertexMap.get(vertex));
            }
        }
        return graphVertexGraphVertexMap.get(node);
    }


    public static GraphVertex cloneV2(GraphVertex vertex) {

        if (vertex == null) return null;

        if (map.containsKey(vertex.field)) {
            return map.get(vertex.field);
        }
        GraphVertex copy = new GraphVertex(vertex.field);
        map.put(copy.field, copy);
        for (GraphVertex node : vertex.graphVertices) {
            copy.graphVertices.add(cloneV2(node));
        }

        return copy;
    }
}
