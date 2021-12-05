class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] isVisitedIsland = new boolean[grid.length][grid[0].length];
        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!isVisitedIsland[i][j] && grid[i][j] == '1') {
                    isVisitedIsland[i][j] = true;
                    numOfIslands++;
                    bfs(new Position(i, j), isVisitedIsland, grid);
                }
            }
        }

        return numOfIslands;
    }
    
    private static void bfs(Position pos, boolean[][] isVisitedIsland, char[][] grid) {
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};

        Queue<Position> positionQueue = new ArrayDeque<>();
        positionQueue.offer(pos);

        while (!positionQueue.isEmpty()) {
            Position cur = positionQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];
                if (0 <= nextY && nextY < grid.length && 0 <= nextX && nextX < grid[0].length) {
                    if (!isVisitedIsland[nextY][nextX] && grid[nextY][nextX] == '1') {
                        isVisitedIsland[nextY][nextX] = true;
                        positionQueue.offer(new Position(nextY, nextX));
                    }
                }
            }
        }
    }
    
    private static class Position {
        private int y;
        private int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}