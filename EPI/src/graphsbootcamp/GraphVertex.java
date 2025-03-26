package graphsbootcamp;

import java.util.ArrayList;
import java.util.List;

public class GraphVertex {

    public int field;
    public List<GraphVertex> graphVertices;

    public GraphVertex(int field) {
        this.field = field;
        this.graphVertices = new ArrayList<>();
    }
}
