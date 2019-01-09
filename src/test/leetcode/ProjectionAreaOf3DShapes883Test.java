package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ProjectionAreaOf3DShapes883Test {
    @Parameterized.Parameters
    public static List<TestItem883> data() {
        List<TestItem883> data = new ArrayList<>();
        data.add(new TestItem883(new int[][]{{2}}, 5));
        data.add(new TestItem883(new int[][]{{1, 2}, {3, 4}}, 17));
        data.add(new TestItem883(new int[][]{{1, 0}, {0, 2}}, 8));
        data.add(new TestItem883(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, 14));
        data.add(new TestItem883(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}, 21));
        return data;
    }

    private static class TestItem883 {
        int[][] grid;
        int expectedArea;

        public TestItem883(int[][] grid, int expectedArea) {
            this.grid = grid;
            this.expectedArea = expectedArea;
        }
    }

    private TestItem883 testItem;

    public ProjectionAreaOf3DShapes883Test(TestItem883 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void projectionAreaSolution1() {
        ProjectionAreaOf3DShapes883.Solution1 solution = new ProjectionAreaOf3DShapes883.Solution1();
        int actualArea = solution.projectionArea(testItem.grid);
        assertEquals(testItem.expectedArea, actualArea);
    }

    @Test
    public void projectionAreaSolution2() {
        ProjectionAreaOf3DShapes883.Solution2 solution = new ProjectionAreaOf3DShapes883.Solution2();
        int actualArea = solution.projectionArea(testItem.grid);
        assertEquals(testItem.expectedArea, actualArea);
    }
}