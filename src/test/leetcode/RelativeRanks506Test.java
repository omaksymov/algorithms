package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RelativeRanks506Test {
    @Parameterized.Parameters
    public static List<TestItem506> data() {
        List<TestItem506> data = new ArrayList<>();
        data.add(new TestItem506(new int[0], new String[0]));
        data.add(new TestItem506(new int[]{1}, new String[]{"Gold Medal"}));
        data.add(new TestItem506(new int[]{2, 1}, new String[]{"Gold Medal", "Silver Medal"}));
        data.add(new TestItem506(new int[]{2, 1, 3}, new String[]{"Silver Medal", "Bronze Medal", "Gold Medal"}));
        data.add(new TestItem506(
                new int[]{1, 2, 3, 4},
                new String[]{"4", "Bronze Medal", "Silver Medal", "Gold Medal"}));
        data.add(new TestItem506(
                new int[]{1, 2, 3, 4, 5},
                new String[]{"5", "4", "Bronze Medal", "Silver Medal", "Gold Medal"}));
        data.add(new TestItem506(
                new int[]{5, 4, 3, 2, 1},
                new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"}));
        data.add(new TestItem506(
                new int[]{1, 4, 3, 5, 2},
                new String[]{"5", "Silver Medal", "Bronze Medal", "Gold Medal", "4"}));
        return data;
    }

    private static class TestItem506 {
        int[] inputArray;
        String[] expectedOutput;

        private TestItem506(int[] inputArray, String[] expectedOutput) {
            this.inputArray = inputArray;
            this.expectedOutput = expectedOutput;
        }
    }

    private TestItem506 testItem;

    public RelativeRanks506Test(TestItem506 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void solution1() {
        RelativeRanks506.Solution1 solution1 = new RelativeRanks506.Solution1();
        String[] actualRes = solution1.findRelativeRanks(testItem.inputArray);
        assertArrayEquals(testItem.expectedOutput, actualRes);
    }

    @Test
    public void solution2() {
        RelativeRanks506.Solution2 solution2 = new RelativeRanks506.Solution2();
        String[] actualRes = solution2.findRelativeRanks(testItem.inputArray);
        assertArrayEquals(testItem.expectedOutput, actualRes);
    }
}