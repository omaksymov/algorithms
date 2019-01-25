package leetcode;

import data_structure.tree.binary.TreeNode;

public class LowestCommonAncestorOfBinaryTree236 {
    /**
     * Recursive postOrder traversal
     */
    static class Solution1 {
        private int lca;

        public int lowestCommonAncestor(TreeNode root, int p, int q) {
            if (root == null) return -1;
            lca = -1;
            recurseTree(root, p, q);
            return lca;
        }

        private boolean recurseTree(TreeNode currentNode, int p, int q) {
            if (currentNode == null) {
                return false;
            }
            int mid = (currentNode.val == p || currentNode.val == q) ? 1 : 0;
            int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
            int right = recurseTree(currentNode.right, p, q) ? 1 : 0;

            // If any two of the flags left, right or mid become True
            if (mid + left + right >= 2) {
                lca = currentNode.val;
            }

            return (mid + left + right > 0);
        }
    }
}
