package mockinterview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IsFibonacciTest {
    @Parameterized.Parameters(name = "val={0}, expected={1}")
    public static Object[][] data() {
        return new Object[][]{
                {0, true},
                {1, true},
                {2, true},
                {3, true},
                {4, false},
                {5, true},
                {6, false},
                {8, true},
                {12, false},
                {13, true},
                {1024, false},
                {28657, true},
                {121394, false},
                {121393, true},
                {Integer.MAX_VALUE, false}
        };
    }

    private int val;
    private boolean expectedRes;

    public IsFibonacciTest(int val, boolean expectedRes) {
        this.val = val;
        this.expectedRes = expectedRes;
    }

    @Test
    public void isFibonacci_Solution1() {
        IsFibonacci.Solution1 sol = new IsFibonacci.Solution1();
        boolean actualRes = sol.isFibonacci(val);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void isFibonacci_Solution2() {
        IsFibonacci.Solution2 sol = new IsFibonacci.Solution2();
        boolean actualRes = sol.isFibonacci(val);
        assertEquals(expectedRes, actualRes);
    }
}