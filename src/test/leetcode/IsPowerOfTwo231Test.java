package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IsPowerOfTwo231Test {
    @Parameterized.Parameters
    public static List<TestItem231> data() {
        List<TestItem231> data = new ArrayList<>();
        data.add(new TestItem231(1, true));
        data.add(new TestItem231(0, false));
        data.add(new TestItem231(-4, false));
        data.add(new TestItem231(-5, false));
        data.add(new TestItem231(2, true));
        data.add(new TestItem231(4, true));
        data.add(new TestItem231(3, false));
        data.add(new TestItem231(7, false));
        data.add(new TestItem231(65, false));
        data.add(new TestItem231(128, true));
        data.add(new TestItem231(512, true));
        data.add(new TestItem231(600, false));
        data.add(new TestItem231(Integer.MAX_VALUE, false));
        return data;
    }

    @Test
    public void isPowerOfTwo_Solution1() {
        IsPowerOfTwo231.Solution1 solution = new IsPowerOfTwo231.Solution1();
        boolean isPowerOfTwoActual = solution.isPowerOfTwo(testItem.n);
        assertEquals(testItem.isPowerOfTwo, isPowerOfTwoActual);
    }

    @Test
    public void isPowerOfTwo_Solution2() {
        IsPowerOfTwo231.Solution2 solution = new IsPowerOfTwo231.Solution2();
        boolean isPowerOfTwoActual = solution.isPowerOfTwo(testItem.n);
        assertEquals(testItem.isPowerOfTwo, isPowerOfTwoActual);
    }

    private TestItem231 testItem;

    public IsPowerOfTwo231Test(TestItem231 testItem) {
        this.testItem = testItem;
    }

    private static class TestItem231 {
        int n;
        boolean isPowerOfTwo;

        private TestItem231(int n, boolean isPowerOfTwo) {
            this.n = n;
            this.isPowerOfTwo = isPowerOfTwo;
        }
    }
}