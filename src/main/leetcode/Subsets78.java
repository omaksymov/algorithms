package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets78 {

    /**
     * In this solution idea is to imitate recursion binary tree, where left subtrees don't contain element
     * with index equal to current level, right subtrees - contain.
     * On each step we multiply the number of subsets by 2.
     */
    private static class Solution1 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            int n = nums.length;
            if (n == 0) {
                result.add(new LinkedList<>());
                return result;
            }
            int curNum;
            List<TreeNode> curLevelNodes;
            List<TreeNode> prevLevelNodes = new LinkedList<>();
            prevLevelNodes.add(new TreeNode(new LinkedList<>()));
            for (int i = 0; i < n; ++i) {
                curNum = nums[i];
                curLevelNodes = new LinkedList<>();
                for (TreeNode node : prevLevelNodes) {
                    node.left = new TreeNode(node.val);
                    node.right = new TreeNode(node.val);
                    node.right.val.add(curNum);
                    curLevelNodes.add(node.left);
                    curLevelNodes.add(node.right);
                }
                prevLevelNodes = curLevelNodes;
            }
            for (TreeNode node: prevLevelNodes) {
                result.add(node.val);
            }
            return result;
        }

        private static class TreeNode {
            TreeNode left;
            TreeNode right;
            List<Integer> val;
            TreeNode(List<Integer> values) {
                val = new LinkedList<>(values);
            }
        }
    }

    /**
     * Considering idea in Solution1, we know beforehand that number of subsets will be 2^n.
     * So we generate required amount of lists for output first, then fill internal lists (subsets) with help of
     * bit manipulation:
     * i.e. [1, 2, 3]
     * j: from 0 to Math.pow(2, n) - 1, binary representation:
     * 000
     * 001 (j >> 2) & 1 != 0 => add 3
     * 010 (j >> 1) & 1 != 0 => add 2;
     * 011 (j >> 1) & 1 != 0 => add 2; (j >> 0) & 1 != 0 => add 3;
     * 100 (j >> 2) & 1 != 0 => add 1
     * 101 (j >> 2) & 1 != 0 => add 1; (j >> 2) & 1 != 0 => add 3
     * 110 (j >> 2) & 1 != 0 => add 1; (j >> 1) & 1 != 0 => add 2;
     * 111 (j >> 2) & 1 != 0 => add 1; (j >> 1) & 1 != 0 => add 2; (j >> 0) & 1 != 0 => add 3;
     *
     * Note: this solution is based on assumption that input length <=31 (signed integer bits length).
     * We may assume that as 2^31 is quite big number of subsets to verify in tests for this task.
     */
    private static class Solution2 {

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            List<List<Integer>> result = generateResultStub(n);
            if (n == 0) {
                return result;
            }
            int m = result.size();
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < m; j++) {
                    if (((j >> i) & 1) != 0) {
                        result.get(j).add(nums[i]);
                    }
                }
            }
            return result;
        }

        private List<List<Integer>> generateResultStub(int n) {
            int resSize = (int) Math.pow(2, n);
            List<List<Integer>> result = new ArrayList<>(resSize);
            for (int i = 0; i < resSize; i++) {
                result.add(new ArrayList<>(n));
            }
            return result;
        }
    }
}
