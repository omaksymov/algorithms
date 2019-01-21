package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DecodeStringAtIndex880Test {

    @Parameterized.Parameters
    public static List<TestItem880> data() {
        List<TestItem880> data = new ArrayList<>();
        data.add(new TestItem880("leet2code3", 10, "o"));
        data.add(new TestItem880("ha22", 5, "h"));
        data.add(new TestItem880("a2345678999999999999999", 1, "a"));
        return data;

    }

    private static class TestItem880 {
        private String input;
        private int k;
        private String expectedLetter;

        private TestItem880(String input, int k, String expectedLetter) {
            this.input = input;
            this.k = k;
            this.expectedLetter = expectedLetter;
        }
    }

    private TestItem880 testItem;

    public DecodeStringAtIndex880Test(TestItem880 item) {
        testItem = item;
    }

    @Test
    public void testDecodeAtIndex() {
        DecodedStringAtIndex880 sol = new DecodedStringAtIndex880();
        String res = sol.decodeAtIndex(testItem.input, testItem.k);
        assertEquals(testItem.expectedLetter, res);
    }

}