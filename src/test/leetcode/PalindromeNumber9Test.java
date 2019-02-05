package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PalindromeNumber9Test {
    @Parameterized.Parameters
    public static List<TestItem9> data() {
        List<TestItem9> data = new ArrayList<>();
        data.add(new TestItem9(0, true));
        data.add(new TestItem9(1, true));
        data.add(new TestItem9(-1, false));
        data.add(new TestItem9(-121, false));
        data.add(new TestItem9(Integer.MIN_VALUE, false));
        data.add(new TestItem9(12, false));
        data.add(new TestItem9(10, false));
        data.add(new TestItem9(101, true));
        data.add(new TestItem9(1221, true));
        data.add(new TestItem9(131000, false));
        data.add(new TestItem9(Integer.MAX_VALUE, false));
        data.add(new TestItem9(131132, false));
        data.add(new TestItem9(131121, false));
        data.add(new TestItem9(131231, false));
        data.add(new TestItem9(1000021, false));
        data.add(new TestItem9(21120, false));
        return data;
    }

    private TestItem9 testItem;

    public PalindromeNumber9Test(TestItem9 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void isPalindrome_Solution1() {
        PalindromeNumber9.Solution1 solution = new PalindromeNumber9.Solution1();
        boolean actualRes = solution.isPalindrome(testItem.x);
        assertEquals(testItem.isPalindrome, actualRes);
    }

    @Test
    public void isPalindrome_Solution2() {
        PalindromeNumber9.Solution2 solution = new PalindromeNumber9.Solution2();
        boolean actualRes = solution.isPalindrome(testItem.x);
        assertEquals(testItem.isPalindrome, actualRes);
    }

    private static class TestItem9 {
        int x;
        boolean isPalindrome;

        private TestItem9(int x, boolean isPalindrome) {
            this.x = x;
            this.isPalindrome = isPalindrome;
        }
    }
}