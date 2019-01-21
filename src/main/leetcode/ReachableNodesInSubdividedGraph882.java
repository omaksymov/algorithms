package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Starting with an undirected graph (the "original graph") with nodes from 0 to N-1, subdivisions are made to some of the edges.
 * <p>
 * The graph is given as follows: edges[k] is a list of integer pairs (i, j, n) such that (i, j) is an edge of the original graph,
 * <p>
 * and n is the total number of new nodes on that edge.
 * <p>
 * Then, the edge (i, j) is deleted from the original graph, n new nodes (x_1, x_2, ..., x_n) are added to the original graph,
 * <p>
 * and n+1 new edges (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n, j) are added to the original graph.
 * <p>
 * Now, you start at node 0 from the original graph, and in each move, you travel along one edge.
 * <p>
 * Return how many nodes you can reach in at most M moves.
 * <p>
 * Example 1:
 * Input: edges = [[0,1,10],[0,2,1],[1,2,2]], M = 6, N = 3
 * Output: 13
 * Explanation:
 * The nodes that are reachable in the final graph after M = 6 moves are indicated below.
 * <p>
 * Example 2:
 * Input: edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], M = 10, N = 4
 * Output: 23
 * <p>
 * Note:
 * 0 <= edges.length <= 10000
 * 0 <= edges[i][0] < edges[i][1] < N
 * There does not exist any i != j for which edges[i][0] == edges[j][0] and edges[i][1] == edges[j][1].
 * The original graph has no parallel edges.
 * 0 <= edges[i][2] <= 10000
 * 0 <= M <= 10^9
 * 1 <= N <= 3000
 * A reachable node is a node that can be travelled to using at most M moves starting from node 0.
 * <p>
 * See LeetCode <a href="https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/">
 *     Reachable Nodes in subdivided graph</a> problem (882)
 */
public class ReachableNodesInSubdividedGraph882 {
    /**
     * Does not work for large input
     * <p>
     * TODO: implement Dijkstra's algorithm as second solution, to work on large inputs as well
     */
    static class Solution1 {
        private int count;
        private Map<Integer, List<Edge>> nodeToEdges;
        private boolean[] visitedNodes;

        public int reachableNodes(int[][] edges, int M, int N) {
            nodeToEdges = new HashMap<>(N);
            fillNodeToEdgesMap(edges);
            count = 0;
            visitedNodes = new boolean[N];
            dfs(0, M, -1);
            return count;
        }

        // m = remaining steps to complete
        private void dfs(int curNodeIndex, int m, int prevNodeIndex) {
            if (!visitedNodes[curNodeIndex]) {
                count++;
                visitedNodes[curNodeIndex] = true;
            }
            if (m <= 0) return;
            List<Edge> curNodeEdges = nodeToEdges.get(curNodeIndex);
            if (curNodeEdges == null) return;
            for (Edge e : curNodeEdges) {
                if (oppositeNode(e, curNodeIndex) == prevNodeIndex) continue;
                fillVisited(e.visited, m, e.a == curNodeIndex);
                if (m > e.visited.length) {
                    dfs(oppositeNode(e, curNodeIndex), m - (e.visited.length + 1), curNodeIndex);
                }
            }
        }

        private int oppositeNode(Edge e, int curNodeIndex) {
            return e.a == curNodeIndex ? e.b : e.a;
        }

        private void fillVisited(boolean[] visited, int m, boolean fromStart) {
            int n = Math.min(m, visited.length);
            if (fromStart) {
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        count++;
                        visited[i] = true;
                    }
                }
            } else {
                for (int i = visited.length - 1; i >= visited.length - n; i--) {
                    if (!visited[i]) {
                        count++;
                        visited[i] = true;
                    }
                }
            }
        }

        private void fillNodeToEdgesMap(int[][] edges) {
            List<Edge> curNodeEdges;
            for (int i = 0; i < edges.length; i++) {
                Edge edge = new Edge(edges[i]);
                if (nodeToEdges.containsKey(edge.a)) {
                    curNodeEdges = nodeToEdges.get(edge.a);
                } else {
                    curNodeEdges = new ArrayList<>();
                    nodeToEdges.put(edge.a, curNodeEdges);
                }
                curNodeEdges.add(edge);
                if (nodeToEdges.containsKey(edge.b)) {
                    curNodeEdges = nodeToEdges.get(edge.b);
                } else {
                    curNodeEdges = new ArrayList<>();
                    nodeToEdges.put(edge.b, curNodeEdges);
                }
                curNodeEdges.add(edge);
            }
        }

        private static class Edge {
            int a;
            int b;
            boolean[] visited;

            private Edge(int[] edge) {
                this.a = edge[0];
                this.b = edge[1];
                visited = new boolean[edge[2]];
            }
        }
    }
}
