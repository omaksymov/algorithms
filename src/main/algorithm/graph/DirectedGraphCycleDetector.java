package algorithm.graph;

import data_structure.graph.AdjacencyList;

import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class DirectedGraphCycleDetector {
    private enum Color {WHITE, GRAY, BLACK}

    public boolean isCyclePresentUsingColor(AdjacencyList graph) {
        int n = graph.adjacencyList.size();
        Color[] states = new Color[n];
        for (int i = 0; i < n; i++) {
            states[i] = Color.WHITE;
        }
        // graph may be disconnected, so single traversal may not cover all nodes
        // So we start from nodes which are not yet covered
        for (int i = 0; i < n; i++) {
            if (states[i] == Color.WHITE
                    && isCyclePresentForSubtreeIteratively(graph.adjacencyList, i, states)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCyclePresentForSubtreeIteratively(List<List<Integer>> adjacencyList,
                                                        int startNode, Color[] states) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> adj;
        stack.push(startNode);
        Integer curNode;
        while (!stack.empty()) {
            curNode = stack.peek();
            System.out.print("" + curNode + ": ");
            if (states[curNode] == Color.BLACK) {
                stack.pop();
                System.out.println();
                continue;
            }
            states[curNode] = Color.GRAY;
            stack.pop();
            adj = adjacencyList.get(curNode);
            ListIterator<Integer> listIterator = adj.listIterator(adj.size());
            int whiteItemsCount = 0;
            while (listIterator.hasPrevious()) {
                int prev = listIterator.previous();
                System.out.print(prev + ", ");
                if (states[prev] == Color.GRAY) {
                    return true;
                } else if (states[prev] == Color.WHITE) {
                    stack.push(prev);
                    whiteItemsCount++;
                }
            }
            System.out.println();
            if (whiteItemsCount == 0) {
                states[curNode] = Color.BLACK;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DirectedGraphCycleDetector cycleDetector = new DirectedGraphCycleDetector();
        AdjacencyList graph = new AdjacencyList(4);
        graph.addDirected(0, 2);
        graph.addDirected(2, 1);
        graph.addDirected(0, 1);
        graph.addDirected(3, 3);
        System.out.println("Created graph:" + graph.toString());

        boolean res = cycleDetector.isCyclePresentUsingColor(graph);
        String resStr = res ? "" : "no ";
        System.out.println(String.format("There are %scycle(s) in a graph", resStr));
    }

}
