package data_structure.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents graph as list of edges, each represented with pairs of adjacent nodes.
 */
public class GraphAsEdges {
    List<Integer[]> edges;

    public GraphAsEdges(List<Integer[]> edges) {
        this.edges = new ArrayList<>(edges);
    }

    public GraphAsEdges(int e) {
        edges = new ArrayList<>(e);
    }

    /**
     * Add edge to the graph.
     *
     * @param u start node
     * @param v end node
     */
    public void add(int u, int v) {
        Integer[] pair = {u, v};
        edges.add(pair);
    }

    /**
     * Searches for the edge in a graph.
     *
     * @param u start node
     * @param v end node
     * @return true when edge found, false otherwise
     */
    public boolean search(int u, int v) {
        for (Integer[] pair : edges) {
            if (isUndirectedMatch(u, v, pair)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUndirectedMatch(int u, int v, Integer[] pair) {
        return pair[0] == u && pair[1] == v
                || pair[0] == v && pair[1] == u;
    }

    private boolean isDirectedMatch(int u, int v, Integer[] pair) {
        return pair[0] == u && pair[1] == v;
    }

    /**
     * Deletes the edge specified by it's nodes.
     *
     * @param u start node
     * @param v end node
     * @return true when edge found and deleted, false when edge not found
     */
    public boolean delete(int u, int v) {
        Iterator<Integer[]> iterator = edges.iterator();
        Integer[] curPair;
        if (iterator.hasNext()) {
            curPair = iterator.next();
            if (isUndirectedMatch(u, v, curPair)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (edges == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (Integer[] edge : edges) {
            sb.append('{')
                    .append(edge[0])
                    .append(',')
                    .append(edge[1])
                    .append('}')
                    .append(',');
        }
        if (!edges.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1); // last ','
        }
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer[]> edges = new ArrayList<>(5);
        edges.add(new Integer[]{1, 3});
        edges.add(new Integer[]{1, 4});
        edges.add(new Integer[]{3, 4});
        edges.add(new Integer[]{5, 1});
        edges.add(new Integer[]{1, 2});
        GraphAsEdges graph = new GraphAsEdges(edges);
        System.out.println("Creating graph with following adjacencyList:" + graph.toString());

        List<Integer[]> pairs = new ArrayList<>(7);
        pairs.add(new Integer[]{2, 1});
        pairs.add(new Integer[]{3, 2});
        pairs.add(new Integer[]{5, 1});
        pairs.add(new Integer[]{7, 6});
        pairs.add(new Integer[]{3, 1});
        pairs.add(new Integer[]{1, 2});
        pairs.add(new Integer[]{1, 4});
        String presenceStr;

        for (Integer[] pair : pairs) {
            presenceStr = graph.search(pair[0], pair[1]) ? "present" : "absent";
            System.out.println(
                    String.format("Undirected edge between %d and %d is %s", pair[0], pair[1], presenceStr));
        }


    }
}
