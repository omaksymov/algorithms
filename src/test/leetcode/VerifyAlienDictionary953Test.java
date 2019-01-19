package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class VerifyAlienDictionary953Test {
    @Parameterized.Parameters
    public static List<TestItem953> data() {
        List<TestItem953> data = new ArrayList<>();
        // As 'h' comes before 'l' in this language, then the sequence is sorted.
        data.add(new TestItem953(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true));
        data.add(new TestItem953(new String[]{"leetcode", "hello"}, "hlabcdefgijkmnopqrstuvwxyz", false));
        // As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
        data.add(new TestItem953(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false));
        data.add(new TestItem953(new String[]{"world", "word", "ror"}, "worldabcefghijkmnpqstuvxyz", true));
        /*
           The first three characters "app" match, and the second string is shorter (in size.)
           According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank
           character which is less than any other character.
         */
        data.add(new TestItem953(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false));
        data.add(new TestItem953(new String[]{"app", "apple"}, "abcdefghijklmnopqrstuvwxyz", true));
        return data;
    }

    private TestItem953 testItem;

    public VerifyAlienDictionary953Test(TestItem953 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void isAlienSorted_Solution1() {
        VerifyAlienDictionary953.Solution1 solution = new VerifyAlienDictionary953.Solution1();
        boolean actualRes = solution.isAlienSorted(testItem.words, testItem.order);
        assertEquals(testItem.expectedRes, actualRes);
    }

    @Test
    public void isAlienSorted_Solution2() {
        VerifyAlienDictionary953.Solution2 solution = new VerifyAlienDictionary953.Solution2();
        boolean actualRes = solution.isAlienSorted(testItem.words, testItem.order);
        assertEquals(testItem.expectedRes, actualRes);
    }

    private static class TestItem953 {
        private String[] words;
        private String order;
        private boolean expectedRes;

        private TestItem953(String[] words, String order, boolean expectedRes) {
            this.words = words;
            this.order = order;
            this.expectedRes = expectedRes;
        }
    }
}