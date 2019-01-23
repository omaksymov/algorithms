package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReachableNodesInSubdividedGraph882Test {
    @Parameterized.Parameters
    public static List<TestItem882> data() {
        List<TestItem882> data = new ArrayList<>();
        int[][] edges1 = new int[][]{
                {0, 1, 10},
                {0, 2, 1},
                {1, 2, 2}
        };
        data.add(new TestItem882(edges1, 6, 3, 13));

        int[][] edges2 = new int[][]{
                {0, 1, 4},
                {1, 2, 6},
                {0, 2, 8},
                {1, 3, 1}
        };
        data.add(new TestItem882(edges2, 10, 4, 23));

        int[][] edges3 = new int[][]{
                {0, 2, 4},
                {1, 4, 5},
                {1, 3, 1},
                {2, 3, 4},
                {3, 4, 5}
        };
        data.add(new TestItem882(edges3, 17, 5, 24));

        int[][] edges4 = new int[][]{
                {1, 2, 4},
                {1, 4, 5},
                {1, 3, 1},
                {2, 3, 4},
                {3, 4, 5}
        };
        // we start from 0, so can't reach the rest of the graph because of no edges
        data.add(new TestItem882(edges4, 17, 5, 1));

        int[][] edges5 = new int[][]{
                {0, 2, 9}, {0, 1, 6}, {3, 4, 7},
                {2, 3, 8}, {1, 2, 0}, {2, 4, 0},
                {0, 4, 9}, {0, 3, 0}, {1, 4, 2},
                {1, 3, 0}
        };
        // we start from 0, so can't reach the rest of the graph because of no edges
        data.add(new TestItem882(edges5, 3, 5, 19));

        // for very large input time limit exceeded :(
        // see https://leetcode.com/submissions/detail/202714088/testcase/ as example
        return data;
    }

    private static class TestItem882 {
        private int[][] edges;
        private int maxSteps;
        private int verticesCount;
        private int expectedVerticesCovered;

        private TestItem882(int[][] edges, int maxSteps, int verticesCount, int expectedVerticesCovered) {
            this.edges = edges;
            this.maxSteps = maxSteps;
            this.verticesCount = verticesCount;
            this.expectedVerticesCovered = expectedVerticesCovered;
        }
    }

    private TestItem882 testItem;

    public ReachableNodesInSubdividedGraph882Test(TestItem882 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void projectionAreaSolution1() {
        ReachableNodesInSubdividedGraph882.Solution1 solution = new ReachableNodesInSubdividedGraph882.Solution1();
        int res = solution.reachableNodes(testItem.edges, testItem.maxSteps, testItem.verticesCount);
        assertEquals(testItem.expectedVerticesCovered, res);
    }

    @Test
    public void projectionAreaSolution2() {
        ReachableNodesInSubdividedGraph882.Solution2 solution = new ReachableNodesInSubdividedGraph882.Solution2();
        int res = solution.reachableNodes(testItem.edges, testItem.maxSteps, testItem.verticesCount);
        assertEquals(testItem.expectedVerticesCovered, res);
    }
}