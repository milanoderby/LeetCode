class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = (int) Math.sqrt(Integer.MAX_VALUE);

        if (start == num) {
            return true;
        }

        if (end * end == num) {
            return true;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            int squareNum = mid * mid;
            if (squareNum == num) {
                return true;
            } else if (squareNum < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return false;
    }
}