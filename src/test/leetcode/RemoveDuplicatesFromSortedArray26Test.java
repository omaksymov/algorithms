package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class RemoveDuplicatesFromSortedArray26Test {
    @Parameterized.Parameters()
    public static int[][][] data() {
        return new int[][][] {
                // {input array}, {expected array after removing duplicates}
                {{1}, {1}},
                {{1, 2, 3}, {1, 2, 3}},
                {{1, 1, 2}, {1, 2}},
                {{1, 1, 2, 3}, {1, 2, 3}},
                {{1, 1, 2, 2, 2, 3, 3, 3}, {1, 2, 3}},
                {{4, 4, 5, 5, 6, 7, 8}, {4, 5, 6, 7, 8}},
                {{4, 5, 6, 6, 7, 8}, {4, 5, 6, 7, 8}},
                {{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, {0, 1, 2, 3, 4}}
        };
    }
    private int[] input;
    private int[] expected;

    public RemoveDuplicatesFromSortedArray26Test(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void removeDuplicatesTest() {
        RemoveDuplicatesFromSortedArray26 solution = new RemoveDuplicatesFromSortedArray26();
        int readFromOutput = solution.removeDuplicates(input);
        assertArrayEquals(expected, Arrays.copyOf(input, readFromOutput));
    }
}