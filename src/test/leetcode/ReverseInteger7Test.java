package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReverseInteger7Test {
    @Parameterized.Parameters(name = "input: {0}; expected: {1}")
    public static Integer[][] data() {
        return new Integer[][] {
                {0, 0},
                {123, 321},
                {-321, -123},
                {120, 21},
                {Integer.MAX_VALUE, 0},
                {Integer.MIN_VALUE, 0},
                {1463847412, 2147483641},
                {2147483641, 1463847412},
                {-1463847412, -2147483641},
                {-2147483641, -1463847412}
        };
    }

    private int input;
    private int expectedRes;

    public ReverseInteger7Test(int input, int expectedRes) {
        this.input = input;
        this.expectedRes = expectedRes;
    }

    @Test
    public void reverse() {
        ReverseInteger7 sol = new ReverseInteger7();
        int actualRes = sol.reverse(input);
        assertEquals(expectedRes, actualRes);
    }
}