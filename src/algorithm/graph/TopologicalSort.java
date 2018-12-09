package algorithm.graph;

import data_structure.graph.AdjacencyList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class TopologicalSort {
    public List<Integer> dfsBased(AdjacencyList graph) {
        List<Integer> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int v = graph.adjacencyList.size();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSort(graph.adjacencyList, i, visited, stack);
            }
        }
        while(!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private void topologicalSort(List<List<Integer>> adjacencyList, int node,
                                 boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        Integer adjNode;
        List<Integer> adjNodes = adjacencyList.get(node);
        ListIterator<Integer> iterator = adjNodes.listIterator(adjNodes.size());
        while (iterator.hasPrevious()) {
            adjNode = iterator.previous();
            if (!visited[adjNode]) {
                topologicalSort(adjacencyList, adjNode, visited, stack);
            }
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(6);
        graph.addDirected(5, 0);
        graph.addDirected(4, 0);
        graph.addDirected(5, 2);
        graph.addDirected(4, 1);
        graph.addDirected(2, 3);
        graph.addDirected(3, 1);
        TopologicalSort sol = new TopologicalSort();
        List<Integer> res = sol.dfsBased(graph);
        System.out.println(res.toString());
    }
}
