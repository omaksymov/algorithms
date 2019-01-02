package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReverseWordsInAString151Test {
    private static class TestStringsItem {
        String input;
        String expected;

        public TestStringsItem(String input, String expected) {
            this.input = input;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static List<TestStringsItem> data() {
        List<TestStringsItem> data = new ArrayList<>();
        data.add(new TestStringsItem("", ""));
        data.add(new TestStringsItem("a", "a"));
        data.add(new TestStringsItem("Abc", "Abc"));
        data.add(new TestStringsItem("Abc", "Abc"));
        data.add(new TestStringsItem("       abcde       ", "abcde"));
        data.add(new TestStringsItem("The     sky is   blue", "blue is sky The"));
        data.add(new TestStringsItem("The     sky is                    blue", "blue is sky The"));
        data.add(new TestStringsItem(
                "a b c d e f g h i j k l m n o p q r s t u v w x y z ",
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"));
        data.add(new TestStringsItem(
                "abcdefg h i j k lmnopq r s tu vwx   yz ",
                "yz vwx tu s r lmnopq k j i h abcdefg"));
        return data;

    }

    TestStringsItem testItem;

    public ReverseWordsInAString151Test(TestStringsItem item) {
        testItem = item;
    }

    @Test
    public void testSolution1() {
        ReverseWordsInAString151.Solution1 sol = new ReverseWordsInAString151.Solution1();
        String str = testItem.input;
        String res = sol.reverseWords(str);
        assertEquals(testItem.expected, res);
    }

    @Test
    public void testSolution2() {
        ReverseWordsInAString151.Solution2 sol = new ReverseWordsInAString151.Solution2();
        String str = testItem.input;
        String res = sol.reverseWords(str);
        assertEquals(testItem.expected, res);
    }

    @Test
    public void testSolution3() {
        ReverseWordsInAString151.Solution3 sol = new ReverseWordsInAString151.Solution3();
        String str = testItem.input;
        String res = sol.reverseWords(str);
        assertEquals(testItem.expected, res);
    }
}