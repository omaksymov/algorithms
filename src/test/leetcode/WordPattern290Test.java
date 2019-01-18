package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WordPattern290Test {
    private static class TestItem290 {
        private String pattern;
        private String str;
        private boolean isPatternMatch;

        private TestItem290(String pattern, String str, boolean isPatternMatch) {
            this.pattern = pattern;
            this.str = str;
            this.isPatternMatch = isPatternMatch;
        }
    }

    @Parameterized.Parameters
    public static List<TestItem290> data() {
        List<TestItem290> data = new ArrayList<>();
        data.add(new TestItem290("a", "a", true));
        data.add(new TestItem290("abc", "abc", false));
        data.add(new TestItem290("a", "dog", true));
        data.add(new TestItem290("a", "dog cat", false));
        data.add(new TestItem290("ab", "dog", false));
        data.add(new TestItem290("ab", "dog cat", true));
        data.add(new TestItem290("ab", "dog dog", false));
        data.add(new TestItem290("aa", "dog cat", false));
        data.add(new TestItem290("aa", "dog cat", false));
        data.add(new TestItem290("aba", "dog cat dog", true));
        data.add(new TestItem290("bab", "dog cat dog", true));
        data.add(new TestItem290("aab", "dog cat dog", false));
        data.add(new TestItem290("abb", "cat dog dog", true));
        data.add(new TestItem290("abba", "cat dog dog fish", false));
        data.add(new TestItem290("aaaa", "cat dog dog fish", false));
        data.add(new TestItem290("abcd", "the sky is blue", true));
        data.add(new TestItem290("abad", "dog cat dog cow", true));
        data.add(new TestItem290("abad", "dog cat horse cow", false));
        data.add(new TestItem290(
                "abcdefghijklmnopqrstuvwxyz",
                "z y x w v u t s r q p o n m l k j i h g f e d c b a", true));
        return data;

    }

    private TestItem290 testItem;

    public WordPattern290Test(TestItem290 item) {
        testItem = item;
    }

    @Test
    public void wordPattern() {
        WordPattern290 solution = new WordPattern290();
        boolean isActualMatch = solution.wordPattern(testItem.pattern, testItem.str);
        assertEquals(testItem.isPatternMatch, isActualMatch);
    }
}