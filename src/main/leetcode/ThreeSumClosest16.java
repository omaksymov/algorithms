package leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
 * to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        int rightEnd = nums.length - 2;
        int mid, right, sum;
        for (int left = 0; left < rightEnd; left++) {
            mid = left + 1;
            right = nums.length - 1;
            sum = nums[left] + nums[mid] + nums[right];
            while (mid < right) {
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                    if (res == target) return res;
                }
                if (sum > target) {
                    sum -= nums[right--];
                    sum += nums[right];
                } else {
                    sum -= nums[mid++];
                    sum += nums[mid];
                }
            }
        }
        return res;
    }
}
