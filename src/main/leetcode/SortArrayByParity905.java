package leetcode;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1;
        int[] res = new int[A.length];
        while (l <= r) {
            while (l <= r && (A[l] % 2 == 0)) {
                res[l] = A[l];
                l++;
            }
            while (l <= r && (A[r] % 2 == 1)) {
                res[r] = A[r];
                r--;
            }
            if (l > r) break;
            res[l] = A[r];
            res[r] = A[l];
            l++;
            r--;
        }
        return res;
    }
}
