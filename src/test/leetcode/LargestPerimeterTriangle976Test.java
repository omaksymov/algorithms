package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class LargestPerimeterTriangle976Test {
    @Parameterized.Parameters
    public static List<TestItem976> data() {
        List<TestItem976> testItems = new ArrayList<>(2);
        testItems.add(new TestItem976(new int[]{2, 1, 2}, 5));
        testItems.add(new TestItem976(new int[]{1, 2, 1}, 0));
        testItems.add(new TestItem976(new int[]{3, 2, 3, 4}, 10));
        testItems.add(new TestItem976(new int[]{3, 6, 2, 3}, 8));
        return testItems;
    }

    private TestItem976 testItem;

    public LargestPerimeterTriangle976Test(TestItem976 testItem) {
        this.testItem = testItem;
    }

    private static class TestItem976 {
        int[] inputArray;
        int expectedRes;

        private TestItem976(int[] inputArray, int expectedRes) {
            this.inputArray = inputArray;
            this.expectedRes = expectedRes;
        }
    }

    @Test
    public void largestPerimeter() {
        LargestPerimeterTriangle976 solution = new LargestPerimeterTriangle976();
        int actualRes = solution.largestPerimeter(testItem.inputArray);
        assertEquals(testItem.expectedRes, actualRes);
    }
}