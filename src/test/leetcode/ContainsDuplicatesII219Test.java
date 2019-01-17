package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ContainsDuplicatesII219Test {
    @Parameterized.Parameters
    public static List<TestItem219> data() {
        List<TestItem219> data = new ArrayList<>();
        data.add(new TestItem219(new int[]{1, 2, 3, 1}, 3, true));
        data.add(new TestItem219(new int[]{1, 0, 1, 1}, 1, true));
        data.add(new TestItem219(new int[]{1, 2, 3, 1, 2, 3}, 2, false));
        return data;
    }

    private TestItem219 testItem;

    public ContainsDuplicatesII219Test(TestItem219 testItem) {
        this.testItem = testItem;
    }

    private static class TestItem219 {
        int[] input;
        int k;
        boolean expectedResult;

        private TestItem219(int[] input, int k, boolean expectedResult) {
            this.input = input;
            this.k = k;
            this.expectedResult = expectedResult;
        }
    }

    @Test
    public void containsNearbyDuplicates_Solution1() {
        ContainsDuplicatesII219.Solution1 solution = new ContainsDuplicatesII219.Solution1();
        boolean actualResult = solution.containsNearbyDuplicate(testItem.input, testItem.k);
        assertEquals(testItem.expectedResult, actualResult);
    }

    @Test
    public void containsNearbyDuplicates_Solution2() {
        ContainsDuplicatesII219.Solution2 solution = new ContainsDuplicatesII219.Solution2();
        boolean actualResult = solution.containsNearbyDuplicate(testItem.input, testItem.k);
        assertEquals(testItem.expectedResult, actualResult);
    }
}