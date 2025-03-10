package heapsbootcamp;

public class LC_373FindKPairsWithSmallestSum {

//    This method is very similar to the Dijkstra algorithm in that we find the shortest distance between any two nodes.
//    To find the edge with the smallest weight, we heap all of the edge weights. Then we move on to the
//    next node (using minimum weight edge selected). We add all of the edge weights for the edges connected with
//    the node back to the heap from the current node and choose the edge with the lowest weight from the available edges.
//    We use the edge to move to another unvisited node and continue popping nodes and adding edge weights to the heap until
//    all of the nodes are covered.
}
