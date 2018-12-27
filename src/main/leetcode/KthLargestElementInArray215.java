package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * See examples in corresponding test class.
 */
public class KthLargestElementInArray215 {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public int findKthLargest(int[] nums, int k) {
        minHeap = new PriorityQueue<>(k);
        this.k = k;
        if (nums == null || nums.length == 0) return 0;
        for (int a : nums) {
            add(a);
        }
        return minHeap.peek();
    }

    private void add(int a) {
        if (minHeap.size() < k) {
            minHeap.offer(a);
        } else if (minHeap.peek() < a) {
            minHeap.poll();
            minHeap.offer(a);
        }
    }
}
