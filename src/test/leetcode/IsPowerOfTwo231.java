package leetcode;

public class IsPowerOfTwo231 {
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
