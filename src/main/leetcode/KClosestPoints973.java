package leetcode;

import java.util.Arrays;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * See LeetCode <a href="https://leetcode.com/problems/k-closest-points-to-origin/">K Closest Points to Origin</a>
 * problem (973).
 */
public class KClosestPoints973 {
    /**
     * Solution based on sorting of distances approach.
     * Runtime: O(n*log(n))
     * Space: O(n)
     */
    static class Solution1 {
        public int[][] kClosest(int[][] points, int k) {
            int n = points.length;
            int[] distances = new int[n];
            int d;
            for (int i = 0; i < n; i++) {
                d = distance(points, i);
                distances[i] = d;
            }
            Arrays.sort(distances);
            int distK = distances[k-1];
            int[][] res = new int[k][2];
            for (int i = 0, j = 0; i < n && j < k; i++) {
                // We repeat calculation because it's practically faster and less memory consuming than sort additional
                // array of Point(x, y, distance) instead of just sorting int[] of distances.
                // Alternative approach is to consume O(n) more memory for storing unsorted version of distances.
                if (distance(points, i) <= distK) {
                    res[j][0] = points[i][0];
                    res[j][1] = points[i][1];
                    j++;
                }
            }
            return res;
        }

        private int distance(int[][] points, int i) {
            return points[i][0] * points[i][0] +
                   points[i][1] * points[i][1];
        }
    }

    /**
     * Solution1 is O(n*log(n)). Here we attempt to reduce such runtime by focusing on sorting part, which is the major
     * time-consuming part of O(n*log(n)) estimation. Idea is to make k first elements of distances array to be less
     * than any other distance after kth element. Key difference is that there is no need to sort elements after kth and
     * no need to sort first k elements with each other.
     * Runtime: Depends on input. On average we assume that < O(n*log(n)), because not whole array is sorted
     * Space: O(n)
     */
    static class Solution2 {
        private int[][] points;
        private int[] distances;

        public int[][] kClosest(int[][] points, int k) {
            this.points = points;
            int n = points.length;
            distances = new int[n];
            int d;
            for (int i = 0; i < n; i++) {
                d = distance(i);
                distances[i] = d;
            }
            partialSort(0, n - 1, k);
            return Arrays.copyOf(points,k);
        }

        private void partialSort(int start, int end, int k) {
            if (start >= end) return;
            int i = start;
            int j = end;
            int mid = i + (j - i) / 2;
            int pivot = distances[mid];
            while (i < j) {
                while (i < j && distances[i] < pivot) i++;
                while (i < j && distances[j] > pivot) j--;
                swap(i, j);
            }
            int lessThanPivotLength = i - start + 1;
            if (lessThanPivotLength >= k) {
                partialSort(start, i, k);
            } else {
                partialSort(i + 1, end, k - lessThanPivotLength);
            }
        }

        private void swap(int i, int j) {
            int tmpX = points[i][0];
            int tmpY = points[i][1];
            points[i][0] = points[j][0];
            points[i][1] = points[j][1];
            points[j][0] = tmpX;
            points[j][1] = tmpY;
            int tmp = distances[i];
            distances[i] = distances[j];
            distances[j] = tmp;
        }

        private int distance(int i) {
            return points[i][0] * points[i][0] +
                   points[i][1] * points[i][1];
        }
    }
}
