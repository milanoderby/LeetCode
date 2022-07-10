class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isVisited[i][j] = true;
                    boolean isFound = findWord(board, isVisited, i, j, word, 1);
                    if (isFound) {
                        return true;
                    }
                    isVisited[i][j] = false;
                }
            }
        }

        return false;
    }
    
    private static boolean findWord(char[][] board, boolean[][] isVisited, int y, int x,
        String word,
        int nextIndex) {
        if (nextIndex >= word.length()) {
            return true;
        }

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int dirIndex = 0; dirIndex < 4; dirIndex++) {
            int nextY = y + dy[dirIndex];
            int nextX = x + dx[dirIndex];

            if (!(0 <= nextY && nextY < board.length && 0 <= nextX
                && nextX < board[0].length)) {
                continue;
            }

            if (isVisited[nextY][nextX]) {
                continue;
            }

            if (board[nextY][nextX] != word.charAt(nextIndex)) {
                continue;
            }

            isVisited[nextY][nextX] = true;
            boolean isFound = findWord(board, isVisited, nextY, nextX, word, nextIndex + 1);
            if (isFound) {
                return true;
            }
            isVisited[nextY][nextX] = false;
        }

        return false;
    }
}