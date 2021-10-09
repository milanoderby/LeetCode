class Solution {
    public int minPathSum(int[][] grid) {
        int[][] minSum = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    minSum[i][j] = grid[i][j];
                    continue;
                }

                int sum = Integer.MAX_VALUE;
                if (i > 0) {
                    sum = Math.min(sum, minSum[i - 1][j]);
                }

                if (j > 0) {
                    sum = Math.min(sum, minSum[i][j - 1]);
                }

                minSum[i][j] = sum + grid[i][j];
            }
        }

        return minSum[grid.length - 1][grid[0].length - 1];
    }
}