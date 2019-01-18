package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AddDigits258Test {
    @Parameterized.Parameters
    public static List<TestItem258> data() {
        List<TestItem258> data = new ArrayList<>();
        data.add(new TestItem258(0, 0));
        data.add(new TestItem258(1, 1));
        data.add(new TestItem258(8, 8));
        data.add(new TestItem258(9, 9));
        data.add(new TestItem258(10, 1));
        data.add(new TestItem258(11, 2));
        data.add(new TestItem258(18, 9));
        data.add(new TestItem258(25, 7));
        data.add(new TestItem258(101, 2));
        data.add(new TestItem258(256, 4));
        data.add(new TestItem258(1024, 7));
        return data;
    }

    private TestItem258 testItem;

    public AddDigits258Test(TestItem258 testItem) {
        this.testItem = testItem;
    }

    private static class TestItem258 {
        int n;
        int expectedDigit;

        private TestItem258(int n, int expectedDigit) {
            this.n = n;
            this.expectedDigit = expectedDigit;
        }
    }

    @Test
    public void addDigits_Solution1() {
        AddDigits258.Solution1 solution = new AddDigits258.Solution1();
        int actualDigit = solution.addDigits(testItem.n);
        assertEquals(testItem.expectedDigit, actualDigit);
    }

    @Test
    public void addDigits_Solution2() {
        AddDigits258.Solution2 solution = new AddDigits258.Solution2();
        int actualDigit = solution.addDigits(testItem.n);
        assertEquals(testItem.expectedDigit, actualDigit);
    }
}