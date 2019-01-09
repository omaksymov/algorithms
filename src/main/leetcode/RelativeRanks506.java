package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal"
 * and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 *
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks506 {
    static class Solution1 {
        public String[] findRelativeRanks(int[] nums) {
            int n = nums.length;
            String[] res = new String[n];
            if (n == 0) {
                return res;
            }
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>(n, new PairComparator());
            for (int i = 0; i < n; i++) {
                maxHeap.add(new Pair(i, nums[i]));
            }

            Pair gold = maxHeap.poll();
            res[gold.index] = "Gold Medal";
            if (!maxHeap.isEmpty()) {
                Pair silver = maxHeap.poll();
                res[silver.index] = "Silver Medal";
            }
            if (!maxHeap.isEmpty()) {
                Pair bronze = maxHeap.poll();
                res[bronze.index] = "Bronze Medal";
            }
            for (int i = 4; i <= n; i++) {
                Pair curPair = maxHeap.poll();
                res[curPair.index] = String.valueOf(i);
            }
            return res;
        }
    }

    static class Solution2 {
        public String[] findRelativeRanks(int[] nums) {
            int n = nums.length;
            String[] res = new String[n];
            if (n == 0) {
                return res;
            }
            Pair[] indexToValue = new Pair[n];
            for (int i = 0; i < n; i++) {
                indexToValue[i] = new Pair(i, nums[i]);
            }
            Arrays.sort(indexToValue, new PairComparator());
            res[indexToValue[0].index] = "Gold Medal";
            if (n > 1) {
                res[indexToValue[1].index] = "Silver Medal";
            }
            if (n > 2) {
                res[indexToValue[2].index] = "Bronze Medal";
            }
            for (int i = 3; i < n; i++) {
                res[indexToValue[i].index] = String.valueOf(i + 1);
            }
            return res;
        }

    }

    private static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return p2.value - p1.value;
        }
    }

    private static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
