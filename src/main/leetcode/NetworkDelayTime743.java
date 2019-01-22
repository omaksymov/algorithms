package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There are N network nodes, labelled 1 to N.
 * <p>
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
 * v is the target node, and w is the time it takes for a signal to travel from source to target.
 * <p>
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
 * If it is impossible, return -1.
 * <p>
 * Note:
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 */
public class NetworkDelayTime743 {
    static class Solution1 {
        private int N;
        private Map<Integer, List<Edge>> graph;
        private int[] distances;

        public int networkDelayTime(int[][] times, int N, int K) {
            this.N = N;
            graph = new HashMap<>();
            fillGraph(times);
            distances = new int[N + 1];
            fillDistances();
            dfs(K, 0);
            return getMaxDistance();
        }

        private int getMaxDistance() {
            int max = -1;
            for (int dist : distances) {
                if (dist > max) {
                    max = dist;
                }
            }
            return max == Integer.MAX_VALUE ? -1 : max;
        }

        private void dfs(int node, int time) {
            if (time >= distances[node]) return;
            distances[node] = time;
            for (Edge e : graph.get(node)) {
                dfs(e.trg, time + e.ttt);
            }
        }

        private static class Edge {
            private int trg;
            private int ttt;

            private Edge(int target, int timeToTravel) {
                trg = target;
                ttt = timeToTravel;
            }
        }

        private void fillGraph(int[][] times) {
            for (int i = 1; i <= N; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int[] time : times) {
                graph.get(time[0])
                        .add(new Edge(time[1], time[2]));
            }
            for (List<Edge> edges : graph.values()) {
                edges.sort(Comparator.comparingInt(e -> e.ttt));
            }
        }

        private void fillDistances() {
            for (int i = 1; i <= N; i++) {
                distances[i] = Integer.MAX_VALUE;
            }
        }
    }
}
