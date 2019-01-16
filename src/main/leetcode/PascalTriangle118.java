package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * See <a href="https://leetcode.com/problems/pascals-triangle/">LeetCode problem</a> for details.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) return new ArrayList<>();
        List<List<Integer>> pascal = new ArrayList<>(numRows);
        List<Integer> firstRow = new ArrayList<>(1);
        firstRow.add(1);
        pascal.add(firstRow);
        if (numRows == 1) return pascal;
        List<Integer> secondRow = new ArrayList<>(2);
        secondRow.add(1);
        secondRow.add(1);
        pascal.add(secondRow);
        if (numRows == 2) return pascal;
        List<Integer> prevRow = secondRow;
        List<Integer> curRow;
        int i = 3;
        while (i <= numRows) {
            curRow = new ArrayList<>(i);
            curRow.add(1);
            for (int j = 0; j + 1 < i - 1; ++j) {
                curRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            curRow.add(1);
            pascal.add(curRow);
            prevRow = curRow;
            i++;
        }
        return pascal;
    }
}
