package leetcode;

public class IsValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        if (num <= 0 ) return false;
        if (num == 1) return true;
        return binary(num);
    }

    private boolean binary(int num) {
        int m;
        int div;
        int l = 1;
        int r = num;
        while (l < r) {
            m = l + (r - l) / 2;
            div = num / m;
            if (div > m) {
                l = m + 1;
            } else if (div < m) {
                r = m;
            } else return num % m == 0;
        }
        return false;
    }
}
