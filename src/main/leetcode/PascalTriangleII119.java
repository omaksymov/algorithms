package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * See <a href="https://leetcode.com/problems/pascals-triangle-ii/">LeetCode problem</a> for details.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 */
public class PascalTriangleII119 {
    /**
     * Partially re-used solution from {@link PascalTriangleII119}
     */
    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1);
    }


    private List<Integer> generate(int numRows) {
        if (numRows < 1) return new ArrayList<>();
        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>(1);
            firstRow.add(1);
            return firstRow;
        }
        List<Integer> secondRow = new ArrayList<>(2);
        secondRow.add(1);
        secondRow.add(1);
        if (numRows == 2) return secondRow;
        List<Integer> prevRow = secondRow;
        List<Integer> curRow = prevRow;
        int i = 3;
        while (i <= numRows) {
            curRow = new ArrayList<>(i);
            curRow.add(1);
            for (int j = 0; j + 1 < i - 1; ++j) {
                curRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            curRow.add(1);
            prevRow = curRow;
            i++;
        }
        return curRow;
    }
}
