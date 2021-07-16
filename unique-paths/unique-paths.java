class Solution {
    public int uniquePaths(int m, int n) {
        int[][] countOfPath = new int[m + 1][n + 1];
        countOfPath[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                countOfPath[i + 1][j] += countOfPath[i][j];
                countOfPath[i][j + 1] += countOfPath[i][j];
            }
        }

        return countOfPath[m - 1][n - 1];
    }
}