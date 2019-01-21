package leetcode;

public class IsPowerOfFour342 {
    static class Solution1 {
        public boolean isPowerOfFour(int n) {
            if (n <= 0) return false;
            int compare = 1;
            for (int i = 0; i < 31; i++) {
                if ((n & compare) == n) {
                    return true;
                }
                compare <<= 2;
            }
            return false;
        }
    }

    /**
     * Solution based checking if power of 2 and additional matching the pattern 010101...0101 in binary representation,
     * meaning that powers of four in binary representation have their single bit set only ato odd position (1-based
     * indexing from smallest bit)
     * <p>
     * 0x55555555(16) = 0101...0101(2)
     */
    static class Solution2 {
        public boolean isPowerOfFour(int n) {
            return n > 0 && (n & n - 1) == 0 && (n & 0x55555555) == n;
        }
    }

}
