package algorithm.tree;

import data_structure.tree.binary.TreeNode;

/**
 * Post-order recursive traversal of binary tree.
 */
public class PostOrderRecursiveTraversal {
    public String postOrder(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        if (sb.lastIndexOf(",") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private void postOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.val).append(",");
    }

    public static void main(String[] args) {
        BinaryTreeSerializator serializator = new BinaryTreeSerializator();
        String treeSample = "[1,2,3,n,n,4,5]";
       /*
            1
           / \
          2   3
             / \
            4   5
        */
        PostOrderRecursiveTraversal sol = new PostOrderRecursiveTraversal();
        System.out.println(sol.postOrder(serializator.deserialize(treeSample)));
    }
}
