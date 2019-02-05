package leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 */
public class ReverseInteger7 {
    public int reverse(int x) {
        int res = 0;
        int digit;
        final int MIN_LIMIT = Integer.MIN_VALUE / 10;
        final int MAX_LIMIT = Integer.MAX_VALUE / 10;
        while (x != 0) {
            digit = x % 10;
            if (res < MIN_LIMIT
                    || (res == MIN_LIMIT && digit > 8)) {
                return 0;
            }
            if (res > MAX_LIMIT
                    || (res == MAX_LIMIT && digit > 7)) {
                return 0;
            }
            res = res * 10 + digit;
            x /= 10;
        }
        return res;
    }
}
