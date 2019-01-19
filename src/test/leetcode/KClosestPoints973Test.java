package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class KClosestPoints973Test {
    @Parameterized.Parameters
    public static List<TestItem973> data() {
        List<TestItem973> data = new ArrayList<>();
        data.add(new TestItem973(new int[][]{{1, 3}, {-2, 2}}, 1, new int[][]{{-2, 2}}));
        data.add(new TestItem973(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][]{{3, 3}, {-2, 4}}));
        data.add(new TestItem973(
                new int[][]{{9, -6}, {-10, 2}, {4, 0}, {5, 8}, {-10, 10}, {-7, 4}, {-2, 6}},
                6,
                new int[][]{{4, 0}, {-2, 6}, {-7, 4}, {5, 8}, {-10, 2}, {9, -6}}));
        data.add(new TestItem973(
                new int[][]{{1, 2}, {-2, 2}, {1, 1}, {2, 2}, {2, 3}},
                1,
                new int[][]{{1, 1}}));
        return data;
    }

    private static class TestItem973 {
        int[][] points;
        int k;
        int[][] expectedKClosest;

        private TestItem973(int[][] points, int k, int[][] expectedKClosest) {
            this.points = points;
            this.k = k;
            this.expectedKClosest = expectedKClosest;
        }
    }

    private TestItem973 testItem;

    public KClosestPoints973Test(TestItem973 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void kClosestPoint_Solution1() {
        KClosestPoints973.Solution1 solution = new KClosestPoints973.Solution1();
        int[][] res = solution.kClosest(testItem.points, testItem.k);
        assertEquals(res.length, testItem.expectedKClosest.length);
        List<Point> expected = arrayToListOfPoints(testItem.expectedKClosest);
        List<Point> actual = arrayToListOfPoints(res);
        assertTrue(actual.containsAll(expected));
    }

    @Test
    public void kClosestPoint_Solution2() {
        KClosestPoints973.Solution2 solution = new KClosestPoints973.Solution2();
        int[][] res = solution.kClosest(testItem.points, testItem.k);
        assertEquals(res.length, testItem.expectedKClosest.length);
        List<Point> expected = arrayToListOfPoints(testItem.expectedKClosest);
        List<Point> actual = arrayToListOfPoints(res);
        assertTrue(actual.containsAll(expected));
    }

    private List<Point> arrayToListOfPoints(int[][] a) {
        List<Point> list = new ArrayList<>(a.length);
        for (int[] e : a) {
            list.add(new Point(e[0], e[1]));
        }
        return list;
    }

    private static class Point {
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}