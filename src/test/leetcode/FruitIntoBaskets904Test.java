package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FruitIntoBaskets904Test {
    @Parameterized.Parameters
    public static int[][][] data() {
        return new int[][][] {
                {{}, {0}},
                {{0}, {1}}, // can collect only 1 fruit from 1 type of tree
                {{1, 2, 1}, {3}}, // can collect 3 fruits from trees of type 1 and 2: [1, 2, 1]
                {{0, 1, 2, 2}, {3}}, // can collect [1, 2, 2], if start from 0 - then only [0, 1] is possible
                {{1, 2, 3, 2, 2}, {4}}, // collect [2, 3, 2, 2], otherwise only [1, 2]
                {{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}, {5}} // collect [1, 2, 1, 1, 2]. If started at the first tree or
                                                         // the eighth tree, we would only collect 4 fruits.
        };
    }

    private int[] trees;
    private int expectedMaxFruits;

    public FruitIntoBaskets904Test(int[] trees, int[] expectedMaxFruits) {
        this.trees = trees;
        this.expectedMaxFruits = expectedMaxFruits[0];
    }

    @Test
    public void totalFruit() {
        FruitIntoBaskets904 solution = new FruitIntoBaskets904();
        int actualMaxFruits = solution.totalFruit(trees);
        assertThat(actualMaxFruits, equalTo(expectedMaxFruits));
    }
}