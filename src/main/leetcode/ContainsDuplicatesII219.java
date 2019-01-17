package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * See <a href="https://leetcode.com/problems/contains-duplicate-ii/">LeetCode problem</a> for detail and examples
 * in corresponding test class.
 *
 * Example 1:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicatesII219 {
    public static class Solution1 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;
            if (n == 0) return false;
            Map<Integer, Integer> map = new HashMap<>();
            int curCount;
            int limit = Math.min(k + 1, n);
            for (int j = 0; j < limit; j++) {
                curCount = map.getOrDefault(nums[j], 0);
                if (curCount >= 1) {
                    return true;
                }
                map.put(nums[j], curCount + 1);
            }
            int justOut;
            int justIn;
            for (int i = 1; i < n - k; i++) {
                justOut = nums[i - 1];
                map.put(justOut, map.get(justOut) - 1);
                justIn = nums[i + k];
                curCount = map.getOrDefault(justIn, 0);
                if (curCount >= 1) {
                    return true;
                }
                map.put(justIn, curCount + 1);
            }
            return false;
        }
    }

    public static class Solution2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;
            if (n == 0) return false;
            Map<Integer, Integer> map = new HashMap<>();
            Integer prevValue;
            for (int i = 0; i < n; i++) {
                prevValue = map.put(nums[i], i);
                if (prevValue != null && i - prevValue <= k) {
                    return true;
                }
            }
            return false;
        }
    }
}
