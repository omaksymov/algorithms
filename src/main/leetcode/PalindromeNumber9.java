package leetcode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * See examples in a test class.
 *
 * Follow up:
 * Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber9 {
    /*
        Converting to String and checking string for palindrome is pretty straightforward, so below is solution without
        such conversion.
        Idea is to reverse the second half of the integer, then compare first and second halves.
        Also interesting point is that any negative integer (starting with '-') will not be a palindrome as there is
        no corresponding trailing '-'.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int n = countLength(x);
        if (n == 1) return true;
        int halfLength = n / 2;
        int halfIndex = (n % 2 == 1) ? halfLength + 1 : halfLength;
        int secondHalf = 0;
        for (int i = n - 1; i >= halfIndex; i--) {
            secondHalf = secondHalf * 10 + x % 10;
            x /= 10;
        }
        if (n % 2 == 1) {
            x /= 10; // ignore middle digit
        }

        return compare(x, secondHalf, halfLength);
    }

    private int countLength(int x) {
        int count = 1;
        while (x >= 10) {
            x /= 10;
            count++;
        }
        return count;
    }

    private boolean compare(int firstHalf, int secondHalf, int halfLength) {
        int d1, d2;
        for (int i = 1; i <= halfLength; i++) {
            d1 = firstHalf % 10;
            d2 = secondHalf % 10;
            if (d1 != d2) {
                return false;
            }
            firstHalf /= 10;
            secondHalf /= 10;
        }
        return true;
    }
}
