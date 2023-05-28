class Solution {
    private static int[] dy = {-1, 0, 1};
    private static int[] dx = {1, 1, 1};
    private static int DIR_MAX = 3;
    public int maxMoves(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        int[][] maxMove = new int[maxRow][maxCol];
        for (int curX = maxCol - 1; curX >= 0; curX--) {
            for (int curY = 0; curY < maxRow; curY++) {
                for (int k = 0; k < DIR_MAX; k++) {
                    int nextY = curY + dy[k];
                    int nextX = curX + dx[k];

                    if (!(0 <= nextY && nextY < maxRow && nextX < maxCol)) {
                        continue;
                    }

                    if (grid[curY][curX] >= grid[nextY][nextX]) {
                        continue;
                    }

                    maxMove[curY][curX] = Math.max(maxMove[curY][curX], maxMove[nextY][nextX] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < maxRow; i++) {
            answer = Math.max(answer, maxMove[i][0]);
        }
        return answer;
    }
}