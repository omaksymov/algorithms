package leetcode;

import java.util.Arrays;

/**
 * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
 *
 * If it is impossible to form any triangle of non-zero area, return 0.
 *
 * See examples in test class.
 *
 * <a href="https://leetcode.com/problems/largest-perimeter-triangle/">Leetcode problem 976</a>
 */
public class LargestPerimeterTriangle976 {
    /**
     * Total runtime: O(n*log(n))
     * Space complexity: O(1)
     * @param a input
     * @return largest perimeter of triangle with non-zero area
     */
    public int largestPerimeter(int[] a) {
        int n = a.length;
        if (n < 3) return 0;
        Arrays.sort(a); // O(n*log(n))
        for (int i = n - 3; i >= 0; i--) { // O(n)
            if (isNonZeroArea(a, i)) {
                return a[i] + a[i + 1] + a[i + 2];
            }
        }
        return 0;
    }

    // Assuming a is sorted, i < j < k; O(1)
    private boolean isNonZeroArea(int[] a, int i) {
        return a[i] + a[i + 1] > a[i + 2];
    }
}
