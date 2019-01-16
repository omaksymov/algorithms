package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers that is already <b>sorted in ascending order</b>, find two numbers such that they add up
 * to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1
 * must be less than index2.
 * <p>
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumII {
    public static void main(String[] args) {
        TwoSumII solution = new TwoSumII();
        int[] res = solution.twoSum(new int[]{2, 3, 5, 7, 9, 11, 15}, 16);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum(int[] numbers, int target) {
        boolean findSmall = false;
        int small = numbers[0];
        int big = target - small;
        int left = 0;
        int right = numbers.length - 1;
        while (true) {
            if (findSmall) {
                findSmall = false;
                left = binarySearch(numbers, left, right - 1, small);
                if (numbers[left] + numbers[right] == target) {
                    break;
                } else {
                    small = numbers[++left];
                    big = target - small;
                }
            } else {
                findSmall = true;
                right = binarySearch(numbers, left + 1, right, big);
                if (numbers[left] + numbers[right] == target) {
                    break;
                } else {
                    big = numbers[right];
                    small = target - big;
                }
            }
        }
        return new int[]{left + 1, right + 1};
    }

    private int binarySearch(int[] a, int left, int right, int target) {
        int l = left;
        int r = right;
        while (l < r) {
            // note that l - r < 0 - it's important
            int mid = r + (l - r) / 2;
            if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}
