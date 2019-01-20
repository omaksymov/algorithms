package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * <p>
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * <p>
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 * <p>
 * Example 1:
 * Input: [1,2,3,4]
 * Output: "23:41"
 * <p>
 * Example 2:
 * Input: [5,5,5,5]
 * Output: ""
 * <p>
 * Note:
 * A.length == 4
 * 0 <= A[i] <= 9
 * <p>
 * See LeetCode <a href="https://leetcode.com/problems/largest-time-for-given-digits/">Largest Time from given digits</a> problem (949).
 */
public class LargestTimeFromGivenDigits949 {
    /**
     *
     * Runtime: O(1) - we have fixed length of input, so even nested cycles are limited with O(4)=O(1).
     * Space: O(1) = 3 additional lists of max length 4, which is fixed length, does not depend much on input.
     */
    public String largestTimeFromDigits(int[] a) {
        List<Integer> allPos = new ArrayList<>(4);
        List<Integer> h1Pos = new ArrayList<>(4);
        List<Integer> m1Pos = new ArrayList<>(4);
        fillPossiblePositions(a, 9, allPos);
        fillPossiblePositions(a, 2, h1Pos);
        fillPossiblePositions(a, 5, m1Pos);
        int maxTime = -1, time;
        for (Integer h1 : h1Pos) {
            for (Integer h2 : allPos) {
                if (h2.equals(h1) || (a[h1] == 2 && a[h2] >= 4)) continue;
                for (Integer m1 : m1Pos) {
                    if (m1.equals(h1) || m1.equals(h2)) continue;
                    int m2 = 6 - h1 - h2 - m1;
                    time = (a[h1] * 10 + a[h2]) * 60 + a[m1] * 10 + a[m2];
                    if (time > maxTime) {
                        maxTime = time;
                    }
                }
            }
        }
        if (maxTime == -1) return "";
        int hours = maxTime / 60;
        int mins = maxTime % 60;
        StringBuilder sb = new StringBuilder(5);
        sb.append(hours / 10)
                .append(hours % 10)
                .append(':')
                .append(mins / 10)
                .append(mins % 10);
        return sb.toString();
    }

    private void fillPossiblePositions(int[] a, int limit, List<Integer> pos) {
        for (int i = 0; i < 4; i++) {
            if (a[i] <= limit) {
                pos.add(i);
            }
        }
    }
}
