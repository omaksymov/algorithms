package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class LetterCasePermutation784Test {
    private static class TestItem784 {
        private String input;
        private Set<String> expected;

        private TestItem784(String input, Set<String> expected) {
            this.input = input;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static List<TestItem784> data() {
        List<TestItem784> data = new ArrayList<>();
        Set<String> hashSet1 = new HashSet<>();
        hashSet1.add("");
        data.add(new TestItem784("", hashSet1));
        Set<String> hashSet2 = new HashSet<>();
        hashSet2.add("a1b2");
        hashSet2.add("A1b2");
        hashSet2.add("a1B2");
        hashSet2.add("A1B2");
        data.add(new TestItem784("a1b2", hashSet2));
        Set<String> hashSet3 = new HashSet<>();
        hashSet3.add("3z4");
        hashSet3.add("3Z4");
        data.add(new TestItem784("3z4", hashSet3));
        Set<String> hashSet4 = new HashSet<>();
        hashSet4.add("12345");
        data.add(new TestItem784("12345", hashSet4));
        return data;

    }

    private TestItem784 testItem;

    public LetterCasePermutation784Test(TestItem784 item) {
        testItem = item;
    }

    @Test
    public void letterCasePermutation() {
        LetterCasePermutation784 solution = new LetterCasePermutation784();
        List<String> res = solution.letterCasePermutation(testItem.input);
        assertEquals(testItem.expected.size(), res.size());
        assertTrue(res.containsAll(testItem.expected));
    }
}