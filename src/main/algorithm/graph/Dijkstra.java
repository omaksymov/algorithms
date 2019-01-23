package algorithm.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Dijkstra's algorithm is an algorithm for finding the shortest paths between nodes in a graph,
 * which may represent, for example, road networks.
 */
public class Dijkstra {
    private Map<Integer, List<Edge>> graph;
    private int[] distances;
    // PriorityQueue for minHeap: nodes with lowest distance will be on top of the heap
    private PriorityQueue<Integer> unvisitedNodes;
    /**
     * Algorithm finds the shortest possible path from point A to point B in graph represented by directed edges with weights.
     * @param graph represented as array of [u,v,w] values, where u - source node, v - destination node, w - weight.
     *              We assume that nodes are denoted by numbers 1..n
     * @param n number of nodes in a graph (some nodes may not have any edges, so may be absent in 'graph' array
     * @param startNode starting point of the path to find
     * @param targetNode destination point of the path to find
     * @return shortest possible path from startNode to targetNode in given graph, or -1 if no such path found
     */
    public int findShortestPathToNode(int[][] graph, int n, int startNode, int targetNode) {
        this.graph = new HashMap<>();
        parseGraph(graph, n);

        distances = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[startNode] = 0;
        boolean[] visited = new boolean[n + 1];
        unvisitedNodes = new PriorityQueue<>(new NodeDistanceComparator());
        unvisitedNodes.add(startNode);
        int curNode = unvisitedNodes.peek();
        while (curNode != -1) {
            for (Edge e : this.graph.get(curNode)) {
                checkNode(e.v, distances[curNode] + e.weight, visited);
            }
            visited[curNode] = true;
            unvisitedNodes.poll();
            if (curNode == targetNode) break;
            curNode = getNextNode();
        }

        return distances[targetNode] == Integer.MAX_VALUE ? -1 : distances[targetNode];
    }

    private class NodeDistanceComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return distances[i1] - distances[i2];
        }
    }

    private int getNextNode() {
        return !unvisitedNodes.isEmpty() ? unvisitedNodes.peek() : -1;
    }

    private void checkNode(int node, int distance, boolean[] visited) {
        if (visited[node]) return;
        if (distance < distances[node]) {
            if (distances[node] != Integer.MAX_VALUE) {
                unvisitedNodes.remove(node);
            }
            distances[node] = distance;
            unvisitedNodes.add(node);
        }
    }

    private static class Edge {
        // end node of directed edge
        private int v;
        private int weight;

        private Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    private void parseGraph(int[][] edges, int n) {
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }
    }

}
