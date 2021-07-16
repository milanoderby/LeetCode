class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minPathSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int prevMinPath = Integer.MAX_VALUE;
                if (i > 0) {
                    prevMinPath = Math.min(prevMinPath, minPathSum[i - 1][j]);
                }

                if (j > 0) {
                    prevMinPath = Math.min(prevMinPath, minPathSum[i][j - 1]);
                }

                if (prevMinPath == Integer.MAX_VALUE) {
                    minPathSum[i][j] = grid[i][j];
                } else {
                    minPathSum[i][j] = prevMinPath + grid[i][j];
                }
            }
        }

        return minPathSum[m - 1][n - 1];
    }
}