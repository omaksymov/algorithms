package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ThreeSumClosest16Test {
    @Parameterized.Parameters
    public static List<Test16Item> data() {
        List<Test16Item> data = new ArrayList<>();
        data.add(new Test16Item(new int[]{-1, 2, 1, -4}, 1, 2));
        data.add(new Test16Item(new int[]{-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33}, 0, 0));
        data.add(new Test16Item(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82, 82));
        return data;
    }

    private static class Test16Item {
        private int[] inputArray;
        private int target;
        private int expectedResult;

        Test16Item(int[] inputArray, int target, int expectedResult) {
            this.inputArray = inputArray;
            this.target = target;
            this.expectedResult = expectedResult;
        }
    }

    private Test16Item testData;

    public ThreeSumClosest16Test(Test16Item testData) {
        this.testData = testData;
    }

    @Test
    public void threeSumClosest() {
        ThreeSumClosest16 solution = new ThreeSumClosest16();
        int actualResult = solution.threeSumClosest(testData.inputArray, testData.target);
        assertEquals(testData.expectedResult, actualResult);
    }
}