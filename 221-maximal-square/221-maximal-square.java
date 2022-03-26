class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] maximalSquare = new int[matrix.length][matrix[0].length];

        int maxSquare = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    maximalSquare[i][j] = matrix[i][j] - '0';
                    maxSquare = Math.max(maxSquare, maximalSquare[i][j]);
                    continue;
                }

                if (matrix[i][j] == '1') {
                    int prevMaxSquare = Math.min(maximalSquare[i - 1][j - 1],
                        maximalSquare[i - 1][j]);
                    prevMaxSquare = Math.min(prevMaxSquare, maximalSquare[i][j - 1]);
                    maximalSquare[i][j] = prevMaxSquare + 1;

                    maxSquare = Math.max(maxSquare, maximalSquare[i][j]);
                }
            }
        }
        return maxSquare * maxSquare;
    }}