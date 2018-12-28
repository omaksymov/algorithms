package interviewio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)
public class KthSmallestElementInArrayTest {
    @Parameterized.Parameters
    public static List<TestItem> data() {
        List<TestItem> testItems = new ArrayList<>();
        testItems.add(new TestItem(new int[]{1, 6, 3, 9, 8, 5}, 3, 5));
        testItems.add(new TestItem(new int[]{2, 3, 0, 6}, 1, 0));
        testItems.add(new TestItem(new int[]{10, 2, 5, 6, 11, 3, 15}, 4, 6));
        testItems.add(new TestItem(new int[]{10, 2, 5, 6, 11, 3, 15}, 5, 10));
        testItems.add(new TestItem(new int[]{10, 2, 5, 15, 11, 3, 0}, 1, 0));
        testItems.add(new TestItem(new int[]{1}, 1, 1));
        testItems.add(new TestItem(new int[]{1, 2}, 2, 2));
        testItems.add(new TestItem(new int[]{1, 2, 3, 4, 5}, 5, 5));
        return testItems;
    }

    private TestItem testItem;

    public KthSmallestElementInArrayTest(TestItem testItem) {
        this.testItem = testItem;
    }

    private static class TestItem {
        int[] a;
        int k;
        int expectedResult;

        private TestItem(int[] a, int k, int expectedResult) {
            this.a = a;
            this.k = k;
            this.expectedResult = expectedResult;
        }
    }

    @Test
    public void kthSmallestElementTest() {
        KthSmallestElementInArray solution = new KthSmallestElementInArray();
        int actualResult = solution.kthSmallestElement(testItem.a, testItem.k);
        assertThat(actualResult, equalTo(testItem.expectedResult));
    }
}