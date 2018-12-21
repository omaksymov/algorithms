package algorithm.graph;

import data_structure.graph.AdjacencyList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Breadth-first search in a graph
 */
public class BFS {

    /**
     * @return true when nodeToSearch is found, false otherwise
     */
    public boolean bfs(AdjacencyList graph, int startNode, int nodeToSearch) {
        if (graph == null || graph.adjacencyList.isEmpty()) {
            return false;
        }
        int n = graph.adjacencyList.size();
        boolean[] visited = new boolean[n];
        return bfs(graph, startNode, nodeToSearch, visited);
    }

    private boolean bfs(AdjacencyList graph, int startNode, int nodeToSearch, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> curAdjacent;
        queue.add(startNode);
        Integer curNode;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            if (visited[curNode]) continue;
            if (curNode == nodeToSearch) return true;
            visited[curNode] = true;
            curAdjacent = graph.adjacencyList.get(curNode);
            queue.addAll(curAdjacent);
        }
        return false;
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(5);
        graph.addUndirected(0, 2);
        graph.addUndirected(0, 3);
        graph.addUndirected(2, 3);
        graph.addUndirected(1, 3);
        graph.addUndirected(3, 4);
        System.out.println("Created graph:" + graph.toString());

        BFS sol = new BFS();
        int[] nodesToSearch = {0, 1, 2, 3, 4, 5};
        boolean res;
        String resStr;
        for (int nodeToSearch : nodesToSearch) {
            res = sol.bfs(graph, 0, nodeToSearch);
            resStr = res ? "" : " not";
            System.out.println(String.format("Node %d is%s found", nodeToSearch, resStr));
        }
    }
}
