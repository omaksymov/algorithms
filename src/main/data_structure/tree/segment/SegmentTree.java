package data_structure.tree.segment;

/**
 * Segment tree is useful for cases when need perform several aggregations across different ranges of the same array.
 * See <a href="https://leetcode.com/problems/range-sum-query-immutable/">LeetCode Range Sum Query - Immutable</a>
 * problem for example:
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * <b>There are many calls to sumRange function.</b>
 */
public class SegmentTree {
    private int[] nums;
    private SegmentTreeNode segmentTreeRoot;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        buildSegmentTree();
    }

    public int sumRange(int i, int j) {
        return sumRange(segmentTreeRoot, i, j);
    }

    private void buildSegmentTree() {
        int n = nums.length;
        if (n == 0) {
            segmentTreeRoot = null;
        } else {
            segmentTreeRoot = new SegmentTreeNode(0, n - 1);
            recurseSegmentTree(segmentTreeRoot);
        }
    }

    private int recurseSegmentTree(SegmentTreeNode curNode) {
        int l = curNode.start;
        int r = curNode.end;
        if (l == r) {
            curNode.sum = nums[l];
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        curNode.left = new SegmentTreeNode(l, mid);
        curNode.right = new SegmentTreeNode(mid + 1, r);
        int leftSum = recurseSegmentTree(curNode.left);
        int rightSum = recurseSegmentTree(curNode.right);
        curNode.sum = leftSum + rightSum;
        return curNode.sum;
    }

    private int sumRange(SegmentTreeNode curNode, int i, int j) {
        if (curNode == null) return 0;
        if (j < curNode.start) return 0;
        if (i > curNode.end) return 0;
        if (i <= curNode.start && j >= curNode.end) {
            return curNode.sum;
        }
        return sumRange(curNode.left, i, j) + sumRange(curNode.right, i, j);
    }
}
