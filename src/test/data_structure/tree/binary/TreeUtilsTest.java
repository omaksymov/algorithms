package data_structure.tree.binary;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeUtilsTest {

    @Test
    public void isSameTree_BothNull() {
        boolean actualRes = TreeUtils.isSameTree(null, null);
        assertTrue(actualRes);
    }

    @Test
    public void isSameTree_OneNull1() {
        boolean actualRes = TreeUtils.isSameTree(new TreeNode(1), null);
        assertFalse(actualRes);
    }

    @Test
    public void isSameTree_OneNull2() {
        boolean actualRes = TreeUtils.isSameTree(null, new TreeNode(1));
        assertFalse(actualRes);
    }

    @Test
    public void isSameTree_OneNodeEqual() {
        boolean actualRes = TreeUtils.isSameTree(new TreeNode(1), new TreeNode(1));
        assertTrue(actualRes);
    }

    @Test
    public void isSameTree_OneNodeDifferent() {
        boolean actualRes = TreeUtils.isSameTree(new TreeNode(5), new TreeNode(7));
        assertFalse(actualRes);
    }

    @Test
    public void isSameTree_TwoNodesLeftSame() {
        TreeNode root1 = new TreeNode(10);
        TreeNode left1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(10);
        TreeNode left2 = new TreeNode(5);
        root1.left = left1;
        root2.left = left2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertTrue(actualRes);
    }

    @Test
    public void isSameTree_TwoNodesLeftDifferent() {
        TreeNode root1 = new TreeNode(10);
        TreeNode left1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(10);
        TreeNode left2 = new TreeNode(7);
        root1.left = left1;
        root2.left = left2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertFalse(actualRes);
    }

    @Test
    public void isSameTree_TwoNodesRightSame() {
        TreeNode root1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        root1.right = right1;
        root2.right = right2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertTrue(actualRes);
    }

    @Test
    public void isSameTree_TwoNodesRightDifferent() {
        TreeNode root1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        root1.right = right1;
        root2.right = right2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertFalse(actualRes);
    }

    @Test
    public void isSameTree_PerfectSame() {
        TreeNode root1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(1);
        root1.right = right1;
        root1.left = left1;
        root2.right = right2;
        root2.left = left2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertTrue(actualRes);
    }

    @Test
    public void isSameTree_PerfectDifferent() {
        TreeNode root1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        root1.right = right1;
        root1.left = left1;
        root2.right = right2;
        root2.left = left2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertFalse(actualRes);
    }

    /*
         1              1
        / \     vs       \
       1   1              1
     */
    @Test
    public void isSameTree_FullVsNonFull1() {
        TreeNode root1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(1);
        root1.right = right1;
        root1.left = left1;
        root2.right = right2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertFalse(actualRes);
    }

    /*
         1              1
        /      vs      / \
       1              1   1
     */
    @Test
    public void isSameTree_FullVsNonFull2() {
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(1);
        root1.left = left1;
        root2.right = right2;
        root2.left = left2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertFalse(actualRes);
    }

    /*
         1              1
        / \     vs     / \
       1   2          2   1
     */
    @Test
    public void isSameTree_Mirror() {
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(1);
        root1.left = left1;
        root1.right = right1;
        root2.left = left2;
        root2.right = right2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertFalse(actualRes);
    }

    /*
         1              1
          \     vs     /
           2          2
     */
    @Test
    public void isSameTree_MirrorEmpty() {
        TreeNode root1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        root1.right = right1;
        root2.left = left2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertFalse(actualRes);
    }

    /*
             1              1
            / \     vs     / \
           1   2          1   2
          / \            / \
         3   4          3   4
     */
    @Test
    public void isSameTree_3LevelsSame() {
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode leftLeft1 = new TreeNode(3);
        TreeNode leftRight1 = new TreeNode(4);
        root1.left = left1;
        root1.right = right1;
        left1.left = leftLeft1;
        left1.right = leftRight1;
        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        TreeNode leftLeft2 = new TreeNode(3);
        TreeNode leftRight2 = new TreeNode(4);
        root2.left = left2;
        root2.right = right2;
        left2.left = leftLeft2;
        left2.right = leftRight2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertTrue(actualRes);
    }

    /*
             1              1
            / \     vs     / \
           1   2          1   2
          / \                / \
         3   4              3   4
     */
    @Test
    public void isSameTree_3LevelsDifferent() {
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode leftLeft1 = new TreeNode(3);
        TreeNode leftRight1 = new TreeNode(4);
        root1.left = left1;
        root1.right = right1;
        left1.left = leftLeft1;
        left1.right = leftRight1;
        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        TreeNode rightLeft2 = new TreeNode(3);
        TreeNode rightRight2 = new TreeNode(4);
        root2.left = left2;
        root2.right = right2;
        right2.left = rightLeft2;
        right2.right = rightRight2;
        boolean actualRes = TreeUtils.isSameTree(root1, root2);
        assertFalse(actualRes);
    }
}