class Solution {
    public int minimumTime(int[][] grid) {
        int MAX_TIME = 1_000_000;
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};

        if (grid[0][1] >= 2 && grid[1][0] >= 2) {
            return -1;
        }

        int[][] minimumTime = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                minimumTime[i][j] = MAX_TIME;
            }
        }

        PriorityQueue<Position> positionQueue = new PriorityQueue<>(Comparator.comparingInt(Position::getArriveTime));
        positionQueue.add(new Position(0, 0, 0));

        while (!positionQueue.isEmpty()) {
            Position cur = positionQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];

                if (!(0 <= nextY && nextY < grid.length && 0 <= nextX && nextX < grid[0].length)) {
                    continue;
                }

                // (y, x) 좌표를 밟는 초는 정해져있다.
                // (y + x) 가 짝수이면, 짝수 초
                // (y + x) 가 홀수이면, 홀수 초
                int requiredArriveTime = grid[nextY][nextX];
                if ((nextY + nextX) % 2 != grid[nextY][nextX] % 2) {
                    requiredArriveTime++;
                }

                int minimumArriveTime = Math.max(cur.arriveTime + 1, requiredArriveTime);

                if (minimumTime[nextY][nextX] > minimumArriveTime) {
                    minimumTime[nextY][nextX] = minimumArriveTime;
                    positionQueue.add(new Position(nextY, nextX, minimumArriveTime));
                }
            }
        }
        return minimumTime[grid.length - 1][grid[0].length - 1];
    }
    
    private static class Position {
        private int y;
        private int x;
        private int arriveTime;

        public Position(int y, int x, int arriveTime) {
            this.y = y;
            this.x = x;
            this.arriveTime = arriveTime;
        }

        public int getArriveTime() {
            return arriveTime;
        }
    }
}