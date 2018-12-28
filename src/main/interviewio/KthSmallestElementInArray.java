package interviewio;

/**
 * Task from sample interview at https://www.youtube.com/watch?v=D35llNtkCps from interview.io
 * Find the Kth smallest element in unsorted array in less than O(n*log(n)) runtime (meaning sort solution is not acceptable).
 * Assume that there are no duplicates in input array.
 * Example:
 * a = [2, 5, 6, 10, 11, 3, 15], k = 4 -> 6 // 6 is 4th smallest element in array
 *
 * Note: we'd also assume that heap approach (i.e. {@link leetcode.KthLargestElementInArray215}) is not acceptable here.
 */
public class KthSmallestElementInArray {

    public int kthSmallestElement(int[] a, int k) {
        if (a == null || a.length == 0) throw new IllegalArgumentException("input array is invalid");
        if (k <= 0 || k > a.length) throw new IllegalArgumentException("kth smallest element is out of input array bounds");
        int n = a.length;
        return kthSmallestElement(a, 0, n - 1, k);
    }

    /*
     * Resulting complexity of algorithm below depends on the input:
     * a) On average case we roughly assume that on every recursive iteration we'll cut the number of elements to iterate
     * "by half", so it will be  n + n / 2 + n / 4 + n / 8 + ... (log(n) times), which has upper bound O(2n)=O(n)
     * irrespective of log(n) value.
     * The reason it differs from O(n*log(n)) for sort algorithms is that we don't proceed with both halves of array in
     * our case. For sorting on average it could be n + 2 * n / 2 + 4 * n / 4 + ... (log(n) times) = n * log(n).
     * We don't have these additional multipliers in algorithm below.
     * b) In the worst case we'll reduce the number of elements to iterate by 1, until only 1 element is left, so it will be
     * n + (n - 1) + ... + 1 = (n + 1) * n / 2 ~ O(n^2)
     * c) In the best scenario we'll traverse the input array only once and immediately find the result -> O(n)
     *
     * Additional space required for this algorithm is equivalent to the way we calculate the runtime as we create
     * new array of corresponding size on each iteration. Additionally, recursion stack is filled with reference to
     * array, positions and k on each recursive iteration, so need consider 4 * sizeof(int) * recursionDepth as well.
     * recursionDepth is limited on average with log(n) and maximum with n, thus O(4 * const * log(n)) = O(log(n)) for
     * average and O(n) for worst case;
     * In total, space complexity:
     * a) worst case: O(n^2 + n) = O(n^2)
     * b) average case: O(2n + log(n)) = O(n)
     * c) best case: O(n) // no recursion
     */
    private int kthSmallestElement(int[] a, int start, int end, int k) {
        // idea: let's first put first element of array into "right" place where it would expected to be in sorted array
        int curElement = a[start];
        // we'll store elements less than curElement to the left of "right" place in supplemental array.
        // More than curElement - to the right of the "right" place.
        int n = end - start + 1;
        int[] b = new int[n];
        int bStart = 0, bEnd = n - 1;
        for (int i = start + 1; i <= end; i++) {
            if (a[i] < curElement) {
                b[bStart++] = a[i];
            } else if (a[i] > curElement) {
                b[bEnd--] = a[i];
            }
        }
        b[bStart] = curElement;
        if (bStart == k - 1) return curElement;
        if (bStart > k - 1) return kthSmallestElement(b, 0, bStart - 1, k);
        return kthSmallestElement(b, bStart + 1, n - 1, k - bStart - 1);
    }
}
