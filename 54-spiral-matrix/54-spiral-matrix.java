class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        int curY = 0;
        int curX = 0;

        List<Integer> answer = new ArrayList<>();
        isVisited[0][0] = true;
        answer.add(matrix[curY][curX]);

        int dir = 0;
        int visitCount = 1;
        int limit = matrix.length * matrix[0].length;
        while (visitCount < limit) {
            int nextY = curY + dy[dir];
            int nextX = curX + dx[dir];

            if (!(0 <= nextY && nextY < matrix.length && 0 <= nextX && nextX < matrix[0].length)) {
                dir = (dir + 1) % 4;
                continue;
            }

            if (isVisited[nextY][nextX]) {
                dir = (dir + 1) % 4;
                continue;
            }

            curY = nextY;
            curX = nextX;
            isVisited[curY][curX] = true;
            answer.add(matrix[curY][curX]);
            visitCount++;
        }
        
        return answer;
    }
}