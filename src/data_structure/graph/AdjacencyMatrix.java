package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Assuming 0-based vertices identifiers, this class represents adjacency matrix for the graph nodes.
 */
public class AdjacencyMatrix {
    int[][] a;

    AdjacencyMatrix(int verticesCount) {
        a = new int[verticesCount][verticesCount];
    }

    public boolean searchUndirectedEdge(int u , int v) {
        if (u >= a.length || v >= a.length) return false;
        return a[u][v] == 1 && a[v][u] == 1;
    }

    public boolean searchDirectedEdge(int u , int v) {
        if (u >= a.length || v >= a.length) return false;
        return a[u][v] == 1;
    }

    public void addUndirectedEdge(int u , int v) {
        if (u >= a.length || v >= a.length) return;
        a[u][v] = 1;
        a[v][u] = 1;
    }

    public void addDirectedEdge(int u , int v) {
        if (u >= a.length || v >= a.length) return;
        a[u][v] = 1;
    }

    public void deleteUndirectedEdge(int u, int v) {
        if (u >= a.length || v >= a.length) return;
        a[u][v] = 0;
        a[v][u] = 0;
    }

    public void deleteDirectedEdge(int u, int v) {
        if (u >= a.length || v >= a.length) return;
        a[u][v] = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int i = 0; i < a.length; i++) {
            sb.append(i).append("  ");
        }
        sb.append('\n');
        for (int i = 0; i < a.length; i++) {
            sb.append(i).append(':').append(Arrays.toString(a[i])).append('\n');
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(5);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(3, 4);
        System.out.println("Created graph:");
        System.out.println(graph.toString());

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
            presenceStr = graph.searchUndirectedEdge(pair[0], pair[1]) ? "present" : "absent";
            System.out.println(
                    String.format("Undirected edge between %d and %d is %s", pair[0], pair[1], presenceStr));
        }
    }
}
