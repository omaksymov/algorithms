package leetcode;

import data_structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * See <a href="https://leetcode.com/problems/binary-tree-paths/">LeetCode problem 257</a>
 */
public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        String curPath = Integer.toString(root.val);
        if (root.left == null && root.right == null) {
            res.add(curPath);
            return res;
        }
        if (root.left != null) {
            dfs(root.left, res, curPath);
        }
        if (root.right != null) {
            dfs(root.right, res, curPath);
        }
        return res;
    }

    private void dfs(TreeNode curNode, List<String> res, String curPath) {
        curPath += "->" + curNode.val;
        if (curNode.left == null && curNode.right == null) {
            res.add(curPath);
            return;
        }
        if (curNode.left != null) {
            dfs(curNode.left, res, curPath);
        }
        if (curNode.right != null) {
            dfs(curNode.right, res, curPath);
        }
    }
}
