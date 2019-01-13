package algorithm.tree;

import data_structure.tree.binary.TreeNode;

/**
 * Pre-order recursive traversal of binary tree.
 */
public class PreOrderRecursiveTraversal {
    public String preOrder(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        if (sb.lastIndexOf(",") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(",");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public static void main(String[] args) {
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String treeSample = "[1,2,3,null,null,4,5]";
       /*
            1
           / \
          2   3
             / \
            4   5

          Expected output: 1,2,3,4,5
        */
        PreOrderRecursiveTraversal sol = new PreOrderRecursiveTraversal();
        System.out.println(sol.preOrder(serializer.deserialize(treeSample)));
    }
}
