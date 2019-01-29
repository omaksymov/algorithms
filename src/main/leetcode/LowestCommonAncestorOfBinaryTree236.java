package leetcode;

import data_structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    /**
     * Iterative solution based on parent pointers
     */
    static class Solution2 {

        public int lowestCommonAncestor(TreeNode root, int p, int q) {
            Map<Integer, TreeNode> parents = new HashMap<>();
            Pair pair = search(root, p, q, parents);
            Set<TreeNode> pAncestors = new HashSet<>();
            TreeNode pAnc = pair.p;
            while (pAnc != null) {
                pAncestors.add(pAnc);
                pAnc = parents.get(pAnc.val);
            }
            TreeNode qAnc = pair.q;
            while (qAnc != null) {
                if (pAncestors.contains(qAnc)) {
                    return qAnc.val;
                }
                qAnc = parents.get(qAnc.val);
            }
            return -1; // should not happen
        }

        private Pair search(TreeNode root, int p, int q, Map<Integer, TreeNode> parents) {
            TreeNode pNode = null;
            TreeNode qNode = null;
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            parents.put(root.val, null);
            TreeNode curNode;
            // we assume that p and q are always present in the input tree, so no check for empty stack
            while (pNode == null || qNode == null) {
                curNode = stack.pop();
                if (curNode.val == p) {
                    pNode = curNode;
                }
                if (curNode.val == q) {
                    qNode = curNode;
                }
                if (curNode.right != null) {
                    stack.push(curNode.right);
                    parents.put(curNode.right.val, curNode);
                }
                if (curNode.left != null) {
                    stack.push(curNode.left);
                    parents.put(curNode.left.val, curNode);
                }
            }
            return new Pair(pNode, qNode);
        }

        private static class Pair {
            private TreeNode p;
            private TreeNode q;

            private Pair(TreeNode p, TreeNode q) {
                this.p = p;
                this.q = q;
            }
        }
    }
}
