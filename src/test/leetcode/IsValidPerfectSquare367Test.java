package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IsValidPerfectSquare367Test {
    @Parameterized.Parameters()
    public static List<TestItem367> data() {
        List<TestItem367> data = new ArrayList<>();
        data.add(new TestItem367(1, true)); // 4^0
        data.add(new TestItem367(0, false));
        data.add(new TestItem367(-4, false));
        data.add(new TestItem367(-5, false));
        data.add(new TestItem367(2, false));
        data.add(new TestItem367(4, true));
        data.add(new TestItem367(3, false));
        data.add(new TestItem367(7, false));
        data.add(new TestItem367(8, false));
        data.add(new TestItem367(16, true));
        data.add(new TestItem367(20, false));
        data.add(new TestItem367(21, false));
        data.add(new TestItem367(25, true));
        data.add(new TestItem367(26, false));
        data.add(new TestItem367(64, true));
        data.add(new TestItem367(65, false));
        data.add(new TestItem367(128, false));
        data.add(new TestItem367(512, false));
        data.add(new TestItem367(1024, true));
        data.add(new TestItem367(Integer.MAX_VALUE, false));
        data.add(new TestItem367(Integer.MIN_VALUE, false));
        return data;
    }

    @Test
    public void isPerfectSquare() {
        IsValidPerfectSquare367 solution = new IsValidPerfectSquare367();
        boolean isPerfectSquare = solution.isPerfectSquare(testItem.n);
        assertEquals(testItem.isPerfectSquare, isPerfectSquare);
    }

    private TestItem367 testItem;

    public IsValidPerfectSquare367Test(TestItem367 testItem) {
        this.testItem = testItem;
    }

    private static class TestItem367 {
        private int n;
        private boolean isPerfectSquare;

        private TestItem367(int n, boolean isPerfectSquare) {
            this.n = n;
            this.isPerfectSquare = isPerfectSquare;
        }
    }
}