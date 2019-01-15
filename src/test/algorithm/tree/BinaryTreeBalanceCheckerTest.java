package algorithm.tree;

import data_structure.tree.binary.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinaryTreeBalanceCheckerTest {
    @Parameterized.Parameters
    public static List<BalanceCheckerTestItem> data() {
        List<BalanceCheckerTestItem> data = new ArrayList<>();
        /*
            3
           / \
          9  20
            /  \
           15   7
         */
        data.add(new BalanceCheckerTestItem("[3,9,20,null,null,15,7]",true));
        /*
                   1
                  / \
                 2   2
                / \
               3   3
              / \
             4   4
         */
        data.add(new BalanceCheckerTestItem("[1,2,2,3,3,null,null,4,4]",false));
        return data;
    }

    BalanceCheckerTestItem testItem;

    public BinaryTreeBalanceCheckerTest(BalanceCheckerTestItem testItem) {
        this.testItem = testItem;
    }

    @Test
    public void isBalanced() {
        TreeNode root = new BinaryTreeSerializer().deserialize(testItem.serializedTree);
        assertEquals(testItem.isBalanced, new BinaryTreeBalanceChecker().isBalanced(root));
    }

    private static class BalanceCheckerTestItem {
        private String serializedTree;
        private boolean isBalanced;

        public BalanceCheckerTestItem(String serializedTree, boolean isBalanced) {
            this.serializedTree = serializedTree;
            this.isBalanced = isBalanced;
        }
    }
}