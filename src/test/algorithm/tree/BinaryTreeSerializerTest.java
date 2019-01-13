package algorithm.tree;

import data_structure.tree.binary.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class BinaryTreeSerializerTest {

    @Test
    public void serializeEmpty() {
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(null);
        assertEquals("[]", str);
    }

    @Test
    public void serializeSingleNode() {
        TreeNode root = new TreeNode(1);
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1]", str);
    }

    /*
          1
         /
        2
     */
    @Test
    public void serializeNodeWithLeftChildOnly() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1,2]", str);
    }

    /*
        1
         \
          2
     */
    @Test
    public void serializeNodeWithRightChildOnly() {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1,null,2]", str);
    }

    /*
            5
           / \
          1   7
     */
    @Test
    public void serializeFullTree() {
        TreeNode root = new TreeNode(5);
        TreeNode right = new TreeNode(7);
        TreeNode left = new TreeNode(1);
        root.left = left;
        root.right = right;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[5,1,7]", str);
    }

    /*
            1
           / \
          2   3
             / \
            4   5
     */
    @Test
    public void serializeFullTreeWithHigherRightSubtree() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode right1 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1,2,3,null,null,4,5]", str);
    }

    /*
          1
         / \
        2   3
       / \
      4   5
    */
    @Test
    public void serializeFullTreeWithHigherLeftSubtree() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1,2,3,4,5]", str);
    }

    /*
          1
         / \
        2   3
       /
      4
    */
    @Test
    public void serializeNonFullTree1() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.left = left1;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1,2,3,4]", str);
    }

    /*
          1
         / \
        2   3
         \
          4
    */
    @Test
    public void serializeNonFullTree2() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.right = left2;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1,2,3,null,4]", str);
    }

    /*
              1
             / \
            2   3
               /
              4
        */
    @Test
    public void serializeNonFullTree3() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode right1 = new TreeNode(4);
        root.left = left;
        root.right = right;
        right.left = right1;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1,2,3,null,null,4]", str);
    }

    /*
              1
             / \
            2   3
                 \
                  4
        */
    @Test
    public void serializeNonFullTree4() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode right2 = new TreeNode(4);
        root.left = left;
        root.right = right;
        right.right = right2;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1,2,3,null,null,null,4]", str);
    }

    /*
              1
             / \
            2   3
             \   \
              4   5
        */
    @Test
    public void serializeNonFullTree5() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.right = left2;
        right.right = right2;
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String str = serializer.serialize(root);
        assertEquals("[1,2,3,null,4,null,5]", str);
    }

    @Test
    public void deserializeEmpty() {
        String str = "[]";
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode root = serializer.deserialize(str);
        assertNull(root);
    }

    @Test
    public void deserializeSingleNode() {
        String str = "[5]";
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode root = serializer.deserialize(str);
        assertNotNull(root);
        assertEquals(5, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    /*
          1
         /
        2
     */
    @Test
    public void deserializeNodeWithLeftChildOnly() {
        String str = "[1,2]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(1, actualRoot.val);
        assertNotNull(actualRoot.left);
        assertEquals(2, actualRoot.left.val);
        assertNull(actualRoot.right);
    }

    /*
        1
         \
          2
     */
    @Test
    public void deserializeNodeWithRightChildOnly() {
        String str = "[1,null,2]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(1, actualRoot.val);
        assertNull(actualRoot.left);
        assertNotNull(actualRoot.right);
        assertEquals(2, actualRoot.right.val);
    }

    /*
            5
           / \
          1   7
     */
    @Test
    public void deserializeFullTree() {
        String str = "[5,1,7]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(5, actualRoot.val);
        assertNotNull(actualRoot.left);
        assertEquals(1, actualRoot.left.val);
        assertNotNull(actualRoot.right);
        assertEquals(7, actualRoot.right.val);
    }

    /*
            1
           / \
          2   3
             / \
            4   5
     */
    @Test
    public void deserializeFullTreeWithHigherRightSubtree() {
        String str = "[1,2,3,null,null,4,5]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(1, actualRoot.val);
        assertNotNull(actualRoot.left);
        assertEquals(2, actualRoot.left.val);
        assertNotNull(actualRoot.right);
        assertEquals(3, actualRoot.right.val);
        assertNull(actualRoot.left.left);
        assertNull(actualRoot.left.right);
        assertNotNull(actualRoot.right.left);
        assertEquals(4, actualRoot.right.left.val);
        assertNotNull(actualRoot.right.right);
        assertEquals(5, actualRoot.right.right.val);
    }

    /*
            1
           / \
          2   3
         / \
        4   5
     */
    @Test
    public void deserializeFullTreeWithHigherLeftSubtree() {
        String str = "[1,2,3,4,5]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(1, actualRoot.val);
        assertNotNull(actualRoot.left);
        assertEquals(2, actualRoot.left.val);
        assertNotNull(actualRoot.right);
        assertEquals(3, actualRoot.right.val);
        assertNotNull(actualRoot.left.left);
        assertEquals(4, actualRoot.left.left.val);
        assertNotNull(actualRoot.left.right);
        assertEquals(5, actualRoot.left.right.val);
        assertNull(actualRoot.right.left);
        assertNull(actualRoot.right.right);
    }

    /*
          1
         / \
        2   3
       /
      4
    */
    @Test
    public void deserializeNonFullTree1() {
        String str = "[1,2,3,4]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(1, actualRoot.val);
        assertNotNull(actualRoot.left);
        assertEquals(2, actualRoot.left.val);
        assertNotNull(actualRoot.right);
        assertEquals(3, actualRoot.right.val);
        assertNotNull(actualRoot.left.left);
        assertEquals(4, actualRoot.left.left.val);
        assertNull(actualRoot.left.right);
        assertNull(actualRoot.right.left);
        assertNull(actualRoot.right.right);
    }

    /*
          1
         / \
        2   3
         \
          4
    */
    @Test
    public void deserializeNonFullTree2() {
        String str = "[1,2,3,null,4]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(1, actualRoot.val);
        assertNotNull(actualRoot.left);
        assertEquals(2, actualRoot.left.val);
        assertNotNull(actualRoot.right);
        assertEquals(3, actualRoot.right.val);
        assertNull(actualRoot.left.left);
        assertNotNull(actualRoot.left.right);
        assertEquals(4, actualRoot.left.right.val);
        assertNull(actualRoot.right.left);
        assertNull(actualRoot.right.right);
    }

    /*
          1
         / \
        2   3
           /
          4
    */
    @Test
    public void deserializeNonFullTree3() {
        String str = "[1,2,3,null,null,4]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(1, actualRoot.val);
        assertNotNull(actualRoot.left);
        assertEquals(2, actualRoot.left.val);
        assertNotNull(actualRoot.right);
        assertEquals(3, actualRoot.right.val);
        assertNull(actualRoot.left.left);
        assertNull(actualRoot.left.right);
        assertNotNull(actualRoot.right.left);
        assertEquals(4, actualRoot.right.left.val);
        assertNull(actualRoot.right.right);
    }

    /*
          1
         / \
        2   3
             \
              4
    */
    @Test
    public void deserializeNonFullTree4() {
        String str = "[1,2,3,null,null,null,4]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(1, actualRoot.val);
        assertNotNull(actualRoot.left);
        assertEquals(2, actualRoot.left.val);
        assertNotNull(actualRoot.right);
        assertEquals(3, actualRoot.right.val);
        assertNull(actualRoot.left.left);
        assertNull(actualRoot.left.right);
        assertNull(actualRoot.right.left);
        assertNotNull(actualRoot.right.right);
        assertEquals(4, actualRoot.right.right.val);
    }

    /*
              1
             / \
            2   3
             \   \
              4   5
        */
    @Test
    public void deserializeNonFullTree5() {
        String str = "[1,2,3,null,4,null,5]";

        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        TreeNode actualRoot = serializer.deserialize(str);

        assertNotNull(actualRoot);
        assertEquals(1, actualRoot.val);
        assertNotNull(actualRoot.left);
        assertEquals(2, actualRoot.left.val);
        assertNotNull(actualRoot.right);
        assertEquals(3, actualRoot.right.val);
        assertNull(actualRoot.left.left);
        assertNotNull(actualRoot.left.right);
        assertEquals(4, actualRoot.left.right.val);
        assertNull(actualRoot.right.left);
        assertNotNull(actualRoot.right.right);
        assertEquals(5, actualRoot.right.right.val);
    }
}