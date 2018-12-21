package algorithm.graph;

import data_structure.graph.AdjacencyList;

import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Depth-first search in a graph
 */
public class DFS {

    /**
     * @return true when nodeToSearch is found, false otherwise
     */
    public boolean dfs(AdjacencyList graph, int startNode, int nodeToSearch) {
        if (graph == null || graph.adjacencyList.isEmpty()) {
            return false;
        }
        int n = graph.adjacencyList.size();
        boolean[] visited = new boolean[n];
        return dfs(graph, startNode, nodeToSearch, visited);
    }

    private boolean dfs(AdjacencyList graph, int startNode, int nodeToSearch, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> curAdjacent;
        stack.push(startNode);
        Integer curNode;
        while (!stack.empty()) {
            curNode = stack.pop();
            if (visited[curNode]) continue;
            if (curNode == nodeToSearch) return true;
            visited[curNode] = true;
            curAdjacent = graph.adjacencyList.get(curNode);
            ListIterator<Integer> iterator = curAdjacent.listIterator(curAdjacent.size());
            while (iterator.hasPrevious()) {
                stack.push(iterator.previous());
            }
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

        DFS sol = new DFS();
        int[] nodesToSearch = {0, 1, 2, 3, 4, 5};
        boolean res;
        String resStr;
        for (int nodeToSearch : nodesToSearch) {
            res = sol.dfs(graph, 0, nodeToSearch);
            resStr = res ? "" : " not";
            System.out.println(String.format("Node %d is%s found", nodeToSearch, resStr));
        }
    }
}
