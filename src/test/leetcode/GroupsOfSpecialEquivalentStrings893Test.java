package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class GroupsOfSpecialEquivalentStrings893Test {
    @Parameterized.Parameters
    public static TestItem893[] data() {
        return new TestItem893[]{
                new TestItem893(new String[]{}, 0),
                new TestItem893(new String[]{"a"}, 1),

                // 3 groups ["a","a"], ["b"], ["c","c","c"]
                new TestItem893(new String[]{"a", "b", "c", "a", "c", "c"}, 3),

                // 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
                new TestItem893(new String[]{"aa", "bb", "ab", "ba"}, 4),

                // 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
                new TestItem893(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}, 3),

                // 1 group ["abcd","cdab","adcb","cbad"]
                new TestItem893(new String[]{"abcd", "cdab", "adcb", "cbad"}, 1),
        };
    }

    private static class TestItem893 {
        private String[] input;
        private int expectedGroupsCount;

        TestItem893(String[] input, int expectedGroupsCount) {
            this.input = input;
            this.expectedGroupsCount = expectedGroupsCount;
        }
    }

    private TestItem893 testItem;

    public GroupsOfSpecialEquivalentStrings893Test(TestItem893 item) {
        testItem = item;
    }

    @Test
    public void numSpecialEquivGroups() {
        GroupsOfSpecialEquivalentStrings893 solution = new GroupsOfSpecialEquivalentStrings893();
        int actualGroupsCount = solution.numSpecialEquivGroups(testItem.input);
        assertThat(actualGroupsCount, equalTo(testItem.expectedGroupsCount));
    }
}