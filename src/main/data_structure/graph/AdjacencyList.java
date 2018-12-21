package data_structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Graph represented by adjacency list.
 * NOTE: Given implementation assumes that graph nodes are represented by 0-based indices.
 */
public class AdjacencyList {
    public List<List<Integer>> adjacencyList;

    public AdjacencyList(List<List<Integer>> adjacencyList) {
        this.adjacencyList = new ArrayList<>(adjacencyList);
    }

    public AdjacencyList(int verticesCount) {
        adjacencyList = new ArrayList<>(verticesCount);
        for (int i = 0; i < verticesCount; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    /**
     * Adds undirected edge between given nodes of the graph.
     *
     * @param u first node
     * @param v second node
     */
    public void addUndirected(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    /**
     * Adds directed edge between given nodes of the graph.
     * @param u start node
     * @param v end node
     */
    public void addDirected(int u, int v) {
        adjacencyList.get(u).add(v);
    }

    /**
     * Searches for the undirected edge in a graph.
     *
     * @param u first node
     * @param v second node
     * @return true when edge found, false otherwise
     */
    public boolean searchUndirected(int u, int v) {
        int n = adjacencyList.size();
        if (u >= n || v >= n) return false;
        return adjacencyList.get(u).contains(v)
                || adjacencyList.get(v).contains(u);
    }

    /**
     * Searches for directed edge in a graph.
     *
     * @param u start node
     * @param v end node
     * @return true when edge found, false otherwise
     */
    public boolean searchDirected(int u, int v) {
        int n = adjacencyList.size();
        if (u >= n || v >= n) return false;
        return adjacencyList.get(u).contains(v);
    }

    /**
     * Deletes the edge specified by it's nodes.
     *
     * @param u start node
     * @param v end node
     * @return true when edge found and deleted, false when edge not found
     */
    public boolean deleteUndirected(int u, int v) {
        int n = adjacencyList.size();
        if (u >= n || v >= n) return false;
        List<Integer> list = adjacencyList.get(u);
        boolean res;
        if (list != null) {
            res = list.remove((Integer)v);
        } else {
            return false;
        }
        list = adjacencyList.get(v);
        if (list != null) {
            res &= list.remove((Integer)u);
        }
        return res;
    }

    @Override
    public String toString() {
        if (adjacencyList == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append('{').append('\n');
        int n = adjacencyList.size();
        List<Integer> edgesForNode;
        for (int i = 0; i < n; i++) {
            edgesForNode = adjacencyList.get(i);
            sb.append(i).append(':');
            for (Integer adjacentNode : edgesForNode) {
                sb.append(adjacentNode).append(',');
            }
            if (!edgesForNode.isEmpty()) {
                sb.deleteCharAt(sb.length() - 1); // remove last ','
            }
            sb.append(';');
            sb.append('\n');
        }
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(5);
        graph.addUndirected(0, 2);
        graph.addUndirected(0, 3);
        graph.addUndirected(2, 3);
        graph.addUndirected(1, 3);
        graph.addUndirected(3, 4);
        System.out.println("Created graph:" + graph.toString());

        List<Integer[]> pairs = new ArrayList<>(7);
        pairs.add(new Integer[]{1, 0});
        pairs.add(new Integer[]{2, 1});
        pairs.add(new Integer[]{4, 1});
        pairs.add(new Integer[]{7, 6});
        pairs.add(new Integer[]{2, 0});
        pairs.add(new Integer[]{0, 1});
        pairs.add(new Integer[]{0, 3});
        String presenceStr;

        for (Integer[] pair : pairs) {
            presenceStr = graph.searchUndirected(pair[0], pair[1]) ? "present" : "absent";
            System.out.println(
                    String.format("Undirected edge between %d and %d is %s", pair[0], pair[1], presenceStr));
        }


    }
}
