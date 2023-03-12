class Solution {
    private static int MAX_QUESTION_TYPE = 50;
    private static int MAX_TARGET = 1000;
    private static int DIVISOR = 1_000_000_007;
    
    public int waysToReachTarget(int target, int[][] types) {
        int[][] dp = new int[MAX_QUESTION_TYPE + 1][MAX_TARGET + 1];

        int countOfQuestion = types[0][0];
        int pointOfQuestion = types[0][1];

        for (int j = 0; j <= countOfQuestion; j++) {
            int point = j * pointOfQuestion;
            if (point > MAX_TARGET) {
                break;
            }
            dp[0][point] = 1;
        }

        for (int i = 1; i < types.length; i++) {
            countOfQuestion = types[i][0];
            pointOfQuestion = types[i][1];

            for (int currentPoint = 0; currentPoint <= MAX_TARGET; currentPoint++) {
                for (int k = 0; k <= countOfQuestion; k++) {
                    int pointToPlus = k * pointOfQuestion;
                    if (currentPoint + pointToPlus > MAX_TARGET) {
                        break;
                    }
                    dp[i][currentPoint + pointToPlus] += dp[i - 1][currentPoint];
                    dp[i][currentPoint + pointToPlus] %= DIVISOR;
                }
            }
        }

        return dp[types.length - 1][target];
    }
}