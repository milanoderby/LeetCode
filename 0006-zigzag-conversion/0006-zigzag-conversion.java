class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[][] board = new char[numRows][1000];
        int y = 0;
        int x = 0;

        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows-1 && index < s.length(); i++, index++) {
                board[y][x] = s.charAt(index);
                y++;
            }

            for (int i = 0; i < numRows-1 && index < s.length(); i++, index++) {
                board[y][x] = s.charAt(index);
                y--;
                x++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < 1000; j++) {
                if (board[i][j] != 0) {
                    answer.append(board[i][j]);
                }
            }
        }
        return answer.toString();
    }
}