package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IsPowerOfFour342Test {
    @Parameterized.Parameters
    public static List<TestItem342> data() {
        List<TestItem342> data = new ArrayList<>();
        data.add(new TestItem342(1, true)); // 4^0
        data.add(new TestItem342(0, false));
        data.add(new TestItem342(-4, false));
        data.add(new TestItem342(-5, false));
        data.add(new TestItem342(2, false));
        data.add(new TestItem342(4, true));
        data.add(new TestItem342(3, false));
        data.add(new TestItem342(7, false));
        data.add(new TestItem342(8, false));
        data.add(new TestItem342(16, true));
        data.add(new TestItem342(20, false));
        data.add(new TestItem342(21, false));
        data.add(new TestItem342(65, false));
        data.add(new TestItem342(128, false));
        data.add(new TestItem342(512, false));
        data.add(new TestItem342(600, false));
        data.add(new TestItem342(Integer.MAX_VALUE, false));
        data.add(new TestItem342(Integer.MIN_VALUE, false));
        return data;
    }

    @Test
    public void isPowerOfFour_Solution1() {
        IsPowerOfFour342.Solution1 solution = new IsPowerOfFour342.Solution1();
        boolean isPowerOfFourActual = solution.isPowerOfFour(testItem.n);
        assertEquals(testItem.isPowerOfFour, isPowerOfFourActual);
    }

    @Test
    public void isPowerOfFour_Solution2() {
        IsPowerOfFour342.Solution2 solution = new IsPowerOfFour342.Solution2();
        boolean isPowerOfFourActual = solution.isPowerOfFour(testItem.n);
        assertEquals(testItem.isPowerOfFour, isPowerOfFourActual);
    }

    private TestItem342 testItem;

    public IsPowerOfFour342Test(TestItem342 testItem) {
        this.testItem = testItem;
    }

    private static class TestItem342 {
        int n;
        boolean isPowerOfFour;

        private TestItem342(int n, boolean isPowerOfFour) {
            this.n = n;
            this.isPowerOfFour = isPowerOfFour;
        }
    }
}