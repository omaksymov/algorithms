package leetcode;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 */
public class SubsetsII90 {
    public static void main(String[] args) {
        SubsetsII90 solution = new SubsetsII90();
        List<List<Integer>> res = solution.subsetsWithDup(new int[]{1, 2, 2});
        print(res);
    }

    private static void print(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            for (int v : list) {
                System.out.print(v + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort to have duplicate element consequent
        Arrays.sort(nums); // O(n*log(n))
        List<List<Integer>> res = new ArrayList<>();
        recurse(0, nums, new ArrayList<>(), res);
        return res;

    }

    private void recurse(int pos, int[] nums, List<Integer> path, List<List<Integer>> res) {
        res.add(path);
        int n = nums.length;
        for (int i = pos; i < n; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue;
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(nums[i]);
            recurse(i + 1, nums, newPath, res);
        }
    }
}
