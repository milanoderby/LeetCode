class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        int minimumY = 0;
        int minimumX = -1;
        int maximumY = matrix.length;
        int maximumX = matrix[0].length;

        int y = 0;
        int x = 0;
        int dir = 0;

        List<Integer> answer = new ArrayList<>();
        boolean exit = false;
        while (!exit) {
            answer.add(matrix[y][x]);

            int ny = y + dy[dir];
            int nx = x + dx[dir];
            switch(dir) {
                case 0:
                    if (nx == maximumX) {
                        maximumX = x;
                        y++;
                        dir = (dir + 1) % 4;
                    } else {
                        x = nx;
                    }

                    if (y == maximumY) {
                        exit = true;
                    }
                    break;
                case 1:
                    if (ny == maximumY) {
                        maximumY = y;
                        x--;
                        dir = (dir + 1) % 4;
                    } else {
                        y = ny;
                    }

                    if (x == minimumX) {
                        exit = true;
                    }
                    break;
                case 2:
                    if (nx == minimumX) {
                        minimumX = x;
                        y--;
                        dir = (dir + 1) % 4;
                    } else {
                        x = nx;
                    }

                    if (y == minimumY) {
                        exit = true;
                    }
                    break;
                case 3:
                    if (ny == minimumY) {
                        minimumY = y;
                        x++;
                        dir = (dir + 1) % 4;
                    } else {
                        y = ny;
                    }

                    if (x == maximumX) {
                        exit = true;
                    }
                    break;
            }
        }
        return answer;
    }
}