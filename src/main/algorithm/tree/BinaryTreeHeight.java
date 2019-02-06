package algorithm.tree;

import data_structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
    Compute the height of the binary tree
 */
public class BinaryTreeHeight {

    static class RecursiveSolution {
        public int heightOfTheTree(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(heightOfTheTree(root.left), heightOfTheTree(root.right));
        }
    }

    static class IterativeSolution {

        public int heightOfTheTree(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> stack = new ArrayDeque<>();
            Deque<Integer> heights = new ArrayDeque<>();
            stack.push(root);
            heights.push(1);
            TreeNode curNode;
            int height;
            int maxHeight = 0;
            while (!stack.isEmpty()) {
                curNode = stack.pop();
                height = heights.pop();
                if (isLeaf(curNode)) {
                    maxHeight = Math.max(maxHeight, height);
                } else {
                    if (curNode.right != null) {
                        stack.push(curNode.right);
                        heights.push(height + 1);
                    }
                    if (curNode.left != null) {
                        stack.push(curNode.left);
                        heights.push(height + 1);
                    }
                }
            }
            return maxHeight;
        }

        private boolean isLeaf(TreeNode curNode) {
            return curNode.right == null && curNode.left == null;
        }
    }
}
