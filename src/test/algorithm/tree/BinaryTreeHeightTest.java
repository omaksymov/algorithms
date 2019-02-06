package algorithm.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinaryTreeHeightTest {
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                // no tree
                {"[]", 0},
                // single node
                {"[7]", 1},
                // two nodes
                {"[7,11]", 2},
                /*
                          7
                         /
                        11
                       /
                      1
                     /
                    4
                 */
                {"[7,11,null,1,null,4]", 4},
                /*
                          3
                           \
                            5
                             \
                              2
                 */
                {"[3,null,5,null,2]", 3},
                /*
                     3
                    / \
                   9  20
                     /  \
                    15   7
                */
                {"[3,9,20,null,null,15,7]", 3},
                /*
                           1
                          / \
                         2   2
                        / \
                       3   3
                      / \
                     4   4
                 */

                {"[1,2,2,3,3,null,null,4,4]", 4},
                /*
                    1
                   / \
                  2   3
                   \
                    5
                 */
                {"[1,2,3,null,5]", 3}
        };
    }

    private String serializedTree;
    private int expectedHeight;

    public BinaryTreeHeightTest(String serializedTree, int expectedHeight) {
        this.serializedTree = serializedTree;
        this.expectedHeight = expectedHeight;
    }

    @Test
    public void treeHeight_Recursive() {
        BinaryTreeHeight.RecursiveSolution solution = new BinaryTreeHeight.RecursiveSolution();
        int actualHeight = solution.heightOfTheTree(
                new BinaryTreeSerializer().deserialize(serializedTree));
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    public void treeHeight_Iterative() {
        BinaryTreeHeight.IterativeSolution solution = new BinaryTreeHeight.IterativeSolution();
        int actualHeight = solution.heightOfTheTree(
                new BinaryTreeSerializer().deserialize(serializedTree));
        assertEquals(expectedHeight, actualHeight);
    }
}