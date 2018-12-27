package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class KthLargestElementInArray215Test {
    @Parameterized.Parameters
    public static List<TestItem> data() {
        List<TestItem> testItems = new ArrayList<>(2);
        testItems.add(new TestItem(new int[]{3, 2, 1, 5, 6, 4}, 2, 5));
        testItems.add(new TestItem(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4));
        return testItems;
    }

    private TestItem testItem;

    public KthLargestElementInArray215Test(TestItem testItem) {
        this.testItem = testItem;
    }

    private static class TestItem {
        int[] inputArray;
        int k;
        int expectedRes;

        private TestItem(int[] inputArray, int k, int expectedRes) {
            this.inputArray = inputArray;
            this.k = k;
            this.expectedRes = expectedRes;
        }
    }

    @Test
    public void findKthLargest() {
        KthLargestElementInArray215 solution = new KthLargestElementInArray215();
        int actualResult = solution.findKthLargest(testItem.inputArray, testItem.k);
        assertThat(actualResult, equalTo(testItem.expectedRes));
    }
}