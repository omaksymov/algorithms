package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RomanToInteger13Test {
    @Parameterized.Parameters(name = "input: {0}; expected: {1}")
    public static Object[][] data() {
        return new Object[][] {
                {"I", 1},
                {"II", 2},
                {"III", 3},
                {"IV", 4},
                {"V", 5},
                {"VI", 6},
                {"VII", 7},
                {"VIII", 8},
                {"IX", 9},
                {"X", 10},
                // L = 50, V = 5, III = 3
                {"LVIII", 58},
                // M = 1000, CM = 900, XC = 90 and IV = 4.
                {"MCMXCIV", 1994},
                // max value according to task description
                {"MMMCMLXLIX", 3999}

        };
    }

    private String romanString;
    private int expectedInt;

    public RomanToInteger13Test(String romanString, int expectedInt) {
        this.romanString = romanString;
        this.expectedInt = expectedInt;
    }

    @Test
    public void romanToInt() {
        RomanToInteger13 sol = new RomanToInteger13();
        int actualInt = sol.romanToInt(romanString);
        assertEquals(expectedInt, actualInt);
    }
}