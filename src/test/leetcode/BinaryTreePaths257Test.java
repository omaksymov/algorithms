package leetcode;

import algorithm.tree.BinaryTreeSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinaryTreePaths257Test {
    @Parameterized.Parameters
    public static List<TestItem257> data() {
        List<TestItem257> data = new ArrayList<>();
        /*
            3
           / \
          9  20
            /  \
           15   7
         */
        List<String> expectedPaths1 = new ArrayList<>();
        expectedPaths1.add("3->9");
        expectedPaths1.add("3->20->15");
        expectedPaths1.add("3->20->7");
        data.add(new TestItem257("[3,9,20,null,null,15,7]", expectedPaths1));

        /*
                   1
                  / \
                 2   2
                / \
               3   3
              / \
             4   4
         */
        List<String> expectedPaths2 = new ArrayList<>();
        expectedPaths2.add("1->2");
        expectedPaths2.add("1->2->3");
        expectedPaths2.add("1->2->3->4");
        expectedPaths2.add("1->2->3->4");
        data.add(new TestItem257("[1,2,2,3,3,null,null,4,4]", expectedPaths2));

        /*
            1
           / \
          2   3
           \
            5
         */
        List<String> expectedPaths3 = new ArrayList<>();
        expectedPaths3.add("1->3");
        expectedPaths3.add("1->2->5");
        data.add(new TestItem257("[1,2,3,null,5]", expectedPaths3));
        return data;
    }

    private TestItem257 testItem;

    public BinaryTreePaths257Test(TestItem257 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void binaryTreePaths() {
        BinaryTreePaths257 solution = new BinaryTreePaths257();
        List<String> actualPaths = solution.binaryTreePaths(
                new BinaryTreeSerializer().deserialize(testItem.serializedTree));
        assertEquals(testItem.expectedPaths.size(), actualPaths.size());
        assertTrue(actualPaths.containsAll(testItem.expectedPaths));
    }

    private static class TestItem257 {
        private String serializedTree;
        private List<String> expectedPaths;

        private TestItem257(String serializedTree, List<String> expectedPaths) {
            this.serializedTree = serializedTree;
            this.expectedPaths = expectedPaths;
        }
    }
}