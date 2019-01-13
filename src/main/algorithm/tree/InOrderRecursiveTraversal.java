package algorithm.tree;

import data_structure.tree.binary.TreeNode;

/**
 * In-order recursive traversal of binary tree.
 */
public class InOrderRecursiveTraversal {
    public String inOrder(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        if (sb.lastIndexOf(",") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private void inOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        inOrder(node.left, sb);
        sb.append(node.val).append(",");
        inOrder(node.right, sb);
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
         Expected output: 2,1,4,3,5
        */
        InOrderRecursiveTraversal sol = new InOrderRecursiveTraversal();
        System.out.println(sol.inOrder(serializer.deserialize(treeSample)));
    }
}
