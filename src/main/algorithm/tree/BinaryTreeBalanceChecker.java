package algorithm.tree;

import data_structure.tree.binary.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * "a binary tree in which the depth of the two subtrees of every node never differ by more than 1."
 *
 * See LeetCode <a href="https://leetcode.com/problems/balanced-binary-tree/">"Balanced Binary tree"</a> problem (110).
 */
public class BinaryTreeBalanceChecker {
    public boolean isBalanced(TreeNode root) {
        return nodeInfo(root).isBalanced;
    }

    private NodeInfo nodeInfo(TreeNode root) {
        if (root == null) {
            return new NodeInfo(0, true);
        }
        if (root.left == null && root.right == null) {
            return new NodeInfo(1, true);
        }
        NodeInfo leftNodeInfo = nodeInfo(root.left);
        NodeInfo rightNodeInfo = nodeInfo(root.right);
        int curDepth = 1 + Math.max(leftNodeInfo.depth, rightNodeInfo.depth);
        boolean isCurBalanced = leftNodeInfo.isBalanced
                && rightNodeInfo.isBalanced
                && Math.abs(leftNodeInfo.depth - rightNodeInfo.depth) <= 1;
        return new NodeInfo(curDepth, isCurBalanced);
    }

    /*
        Helper class to avoid using member variable for storing state of the algorithm.
        We need both depth and isBalanced information for every node to avoid redundant passes.
     */
    private static class NodeInfo {
        int depth;
        boolean isBalanced;

        private NodeInfo(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }
}
