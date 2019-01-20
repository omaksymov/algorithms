package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LargestTimeFromGivenDigits949Test {
    @Parameterized.Parameters
    public static List<TestItem949> data() {
        List<TestItem949> data = new ArrayList<>();
        data.add(new TestItem949(new int[]{1, 2, 3, 4}, "23:41"));
        data.add(new TestItem949(new int[]{5, 5, 5, 5}, ""));
        data.add(new TestItem949(new int[]{2, 0, 6, 6}, "06:26"));
        data.add(new TestItem949(new int[]{0, 1, 1, 0}, "11:00"));
        return data;
    }

    private TestItem949 testItem;

    public LargestTimeFromGivenDigits949Test(TestItem949 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void largestTimeFromDigits() {
        LargestTimeFromGivenDigits949 solution = new LargestTimeFromGivenDigits949();
        String actualTime = solution.largestTimeFromDigits(testItem.a);
        assertEquals(testItem.expectedTime, actualTime);
    }

    private static class TestItem949 {
        private int[] a;
        private String expectedTime;

        private TestItem949(int[] a, String expectedTime) {
            this.a = a;
            this.expectedTime = expectedTime;
        }
    }
}