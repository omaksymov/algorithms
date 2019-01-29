package leetcode;

import algorithm.tree.BinaryTreeSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LowestCommonAncestorOfBinaryTree236Test {
    @Parameterized.Parameters
    public static List<TestItem236> data() {
        List<TestItem236> data = new ArrayList<>();
        /*
            3
           / \
          9  20
            /  \
           15   7
         */
        data.add(new TestItem236("[3,9,20,null,null,15,7]", 9, 20, 3));

        /*
                   1
                  / \
                 2   3
                / \
               4   5
              / \
             6   7
         */
        data.add(new TestItem236("[1,2,3,4,5,null,null,6,7]", 2, 7, 2));

        /*
            1
           / \
          2   3
           \
            5
         */
        data.add(new TestItem236("[1,2,3,null,5]", 3, 5, 1));
        return data;
    }

    private TestItem236 testItem;

    public LowestCommonAncestorOfBinaryTree236Test(TestItem236 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void lowestCommonAncestor_Solution1() {
        LowestCommonAncestorOfBinaryTree236.Solution1 solution = new LowestCommonAncestorOfBinaryTree236.Solution1();
        int actualLCA = solution.lowestCommonAncestor(
                new BinaryTreeSerializer().deserialize(testItem.serializedTree), testItem.a, testItem.b);
        assertEquals(testItem.expectedLCA, actualLCA);
    }

    @Test
    public void lowestCommonAncestor_Solution2() {
        LowestCommonAncestorOfBinaryTree236.Solution2 solution = new LowestCommonAncestorOfBinaryTree236.Solution2();
        int actualLCA = solution.lowestCommonAncestor(
                new BinaryTreeSerializer().deserialize(testItem.serializedTree), testItem.a, testItem.b);
        assertEquals(testItem.expectedLCA, actualLCA);
    }

    private static class TestItem236 {
        private String serializedTree;
        private int a;
        private int b;
        private int expectedLCA;

        private TestItem236(String serializedTree, int a, int b, int expectedLCA) {
            this.serializedTree = serializedTree;
            this.a = a;
            this.b = b;
            this.expectedLCA = expectedLCA;
        }
    }
}