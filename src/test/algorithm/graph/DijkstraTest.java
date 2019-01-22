package algorithm.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DijkstraTest {

    @Parameterized.Parameters
    public static List<DijkstraTestItem> data() {
        List<DijkstraTestItem> data = new ArrayList<>();
        data.add(new DijkstraTestItem(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2, 4, 2));
        data.add(new DijkstraTestItem(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1, 3, 2));
        data.add(new DijkstraTestItem(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2, 2, 0));
        data.add(new DijkstraTestItem(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2, 1, 3));
        data.add(new DijkstraTestItem(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 1, 2, 1));
        data.add(new DijkstraTestItem(new int[][]{{1, 2, 10}, {1, 3, 1}, {2, 3, 2}}, 3, 1, 3, 1));
        data.add(new DijkstraTestItem(new int[][]{{1, 2, 4}, {2, 3, 6}, {1, 3, 8}, {2, 4, 1}}, 4, 1, 4, 5));
        data.add(new DijkstraTestItem(new int[][]{{1, 3, 4}, {2, 5, 5}, {2, 4, 1}, {3, 4, 4}, {4, 5, 5}}, 5, 1, 2, -1));
        data.add(new DijkstraTestItem(new int[][]{{2, 3, 4}, {2, 5, 5}, {2, 4, 1}, {3, 4, 4}, {4, 5, 5}}, 5, 1, 4, -1));
        data.add(new DijkstraTestItem(new int[][]{{2, 3, 4}, {2, 5, 5}, {2, 4, 1}, {3, 4, 4}, {4, 5, 5}}, 5, 2, 4, 1));
        data.add(new DijkstraTestItem(new int[][]{{2, 3, 4}, {2, 5, 20}, {2, 4, 15}, {3, 4, 4}, {4, 5, 5}}, 5, 2, 5, 13));
        return data;
    }

    private static class DijkstraTestItem {
        private int[][] edges;
        private int nodesCount;
        private int startNode;
        private int targetNode;
        private int expectedLength; // of the shortest path

        private DijkstraTestItem(int[][] edges, int nodesCount, int startNode, int targetNode, int expectedLength) {
            this.edges = edges;
            this.nodesCount = nodesCount;
            this.startNode = startNode;
            this.targetNode = targetNode;
            this.expectedLength = expectedLength;
        }
    }

    private DijkstraTestItem testItem;

    public DijkstraTest(DijkstraTestItem testItem) {
        this.testItem = testItem;
    }

    @Test
    public void findShortestPath_Dijkstra() {
        Dijkstra solution = new Dijkstra();
        int actualLength = solution
                .findShortestPathToNode(testItem.edges, testItem.nodesCount,
                        testItem.startNode, testItem.targetNode);
        assertEquals(testItem.expectedLength, actualLength);
    }

}