package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NetworkDelayTime743Test {

    @Parameterized.Parameters
    public static List<TestItem883> data() {
        List<TestItem883> data = new ArrayList<>();
        data.add(new TestItem883(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2, 2));
        data.add(new TestItem883(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1, 2));
        data.add(new TestItem883(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2, 3));
        return data;
    }

    private static class TestItem883 {
        private int[][] times;
        private int nodesCount;
        private int startNode;
        private int expectedTime;

        private TestItem883(int[][] times, int nodesCount, int startNode, int expectedTime) {
            this.times = times;
            this.nodesCount = nodesCount;
            this.startNode = startNode;
            this.expectedTime = expectedTime;
        }
    }

    private TestItem883 testItem;

    public NetworkDelayTime743Test(TestItem883 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void networkDelayTime() {
        NetworkDelayTime743.Solution1 solution = new NetworkDelayTime743.Solution1();
        int actualTime = solution.networkDelayTime(testItem.times, testItem.nodesCount, testItem.startNode);
        assertEquals(testItem.expectedTime, actualTime);
    }

}