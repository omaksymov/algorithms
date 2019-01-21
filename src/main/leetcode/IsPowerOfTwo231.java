package leetcode;

public class IsPowerOfTwo231 {
    static class Solution1 {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            int compare = 1;
            for (int i = 0; i < 31; i++) {
                if ((n & compare) == n) {
                    return true;
                }
                compare <<= 1;
            }
            return false;
        }
    }

    /**
     * Solution based on the following fact:
     *
     * 8(10) = 1000(2), 8 - 1 = 7 (10) = 111(2) //(10) means decimal, (2) means binary
     * (n & n - 1) == 0 means there are no common bits, which is true for all powers of 2 (in binary representation of
     * which only 1 bit is filled, all others are 0)
     */
    static class Solution2 {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & n - 1) == 0;
        }
    }

}
