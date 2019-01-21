package leetcode;

/**
 * An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:
 * <p>
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 * Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
 * <p>
 * Example 1:
 * Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * <p>
 * Example 2:
 * Input: S = "ha22", K = 5
 * Output: "h"
 * Explanation:
 * The decoded string is "hahahaha".  The 5th letter is "h".
 * <p>
 * Example 3:
 * Input: S = "a2345678999999999999999", K = 1
 * Output: "a"
 * Explanation:
 * The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 * <p>
 * <p>
 * Note:
 * 2 <= S.length <= 100
 * S will only contain lowercase letters and digits 2 through 9.
 * S starts with a letter.
 * 1 <= K <= 10^9
 * The decoded string is guaranteed to have less than 2^63 letters.
 * <p>
 * See LeetCode <a href="https://leetcode.com/problems/decoded-string-at-index/">Decoded String at Index</a> problem (880)
 */
public class DecodedStringAtIndex880 {
    /**
     * Brute force approach with copying the tape, even up to Kth position, leads to memory limit exceeded error.
     * So idea is to not actually decode the string, but keep track of size of the resulting string only.
     * If K > tape.size -> Kth element in the tape equals to (K % tape.size)th element in the tape.
     * Example:
     * tape: leetcode (size = 8), K = 15
     * leetcodeleetcod... (d is 15th element) K % 8 = 7, 7th element is d
     * <p>
     * Additional note is that resulting letter is one of those from encoded string, so after "decoding" into size only we
     * do backward process to map into the wanted letter in "encoded" string.
     */
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        char c;
        int n = S.length();
        for (int i = 0; i < n; i++) {
            c = S.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }
        return "";
    }
}
