package leetcode;


/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits258 {
    /**
     * Naive, trivial solution
     */
    public static class Solution1 {
        public int addDigits(int num) {
            if (num > 9) {
                int digit;
                int sum = 0;
                while (num > 0) {
                    digit = num % 10;
                    sum += digit;
                    num /= 10;
                }
                return addDigits(sum);
            }
            return num;
        }
    }

    /**
     * Solution based on <a href="https://en.wikipedia.org/wiki/Digital_root">Digital root</a> concept.
     */
    public static class Solution2 {
        public int addDigits(int num) {
            return (num - 1) % 9 + 1;
        }
    }
}
