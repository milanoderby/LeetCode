class Solution {
    private static int dy[] = {-1, 1, 0, 0};
    private static int dx[] = {0, 0, -1, 1};
    
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isVisited[i][j] = true;
                    if (findWord(board, i, j, isVisited, word, 1)) {
                        return true;
                    }
                    isVisited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    private static boolean findWord(char[][] board, int curY, int curX, boolean[][] isVisited, String word, int index) {
        if (index >= word.length()) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nextY = curY + dy[i];
            int nextX = curX + dx[i];
            if (nextY < 0 || nextY >= board.length || nextX < 0 || nextX >= board[0].length) {
                continue;
            }
            if (isVisited[nextY][nextX]) {
                continue;
            }
            
            if (board[nextY][nextX] == word.charAt(index)) {
                isVisited[nextY][nextX] = true;
                if (findWord(board, nextY, nextX, isVisited, word, index + 1)) {
                    return true;
                }
                isVisited[nextY][nextX] = false;
            }
        }
        return false;
    }
}