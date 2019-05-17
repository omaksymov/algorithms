package mockinterview;

/**
 * Define if given number n is a Fibonacci number.
 */
class IsFibonacci {
    /**
     * Just calculate the Fibonacci numbers starting from 0, until it's bigger than input.
     * The trick is to not reach integer overflow, so we subtract instead of adding.
     */
    static class Solution1 {
        boolean isFibonacci(int n) {
            if (n < 0) return false;
            if (n == 0) return true;
            int prev = 0;
            int cur = 1;
            int posPrev = n - cur;
            while (posPrev >= prev) {
                if (posPrev == prev) return true;
                int tmp = prev + cur;
                prev = cur;
                cur = tmp;
                posPrev = n - cur;
            }
            return false;
        }
    }

    /**
     * Sophisticated solution based on the fact that for any Fibonacci number x either
     * 5*x^2+4 or 5*x^2-4 is a perfect square.
     * Additional trick here is to track integer overflow.
     */
    static class Solution2 {
        boolean isFibonacci(int n) {
            if (n < 0) return false;
            long nLong = (long) n;
            long sq5 = 5 * nLong * nLong;
            return isPerfectSquare(sq5 - 4) ||
                    isPerfectSquare(sq5 + 4);
        }

        private boolean isPerfectSquare(long x) {
            if (x < 0) return false;
            long sqrt = (long) Math.sqrt(x);
            return sqrt * sqrt == x;
        }
    }
}
