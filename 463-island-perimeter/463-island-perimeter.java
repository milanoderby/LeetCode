class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimieter = 0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        int ny = i + dy[dir];
                        int nx = j + dx[dir];
                        if (ny < 0 || nx < 0 || ny >= grid.length || nx >= grid[i].length) {
                            perimieter++;
                            continue;
                        }
                        
                        if (grid[ny][nx] == 0) {
                            perimieter++;
                        }
                    }
                }
            }
        }
        return perimieter;
    }
}