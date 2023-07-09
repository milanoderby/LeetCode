class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<Position, Integer> countOfBlackCellMap = new HashMap<>();
        for (int[] coordinate : coordinates) {
            int y = coordinate[0];
            int x = coordinate[1];

            Position pos;
            int count;
            if (y + 1 < m && x + 1 < n) {
                pos = new Position(y, x);
                count = countOfBlackCellMap.getOrDefault(pos, 0);
                countOfBlackCellMap.put(pos, count + 1);
            }

            if (y - 1 >= 0 && x + 1 < n) {
                pos = new Position(y - 1, x);
                count = countOfBlackCellMap.getOrDefault(pos, 0);
                countOfBlackCellMap.put(pos, count + 1);
            }

            if (x - 1 >= 0 && y + 1 < m) {
                pos = new Position(y, x - 1);
                count = countOfBlackCellMap.getOrDefault(pos, 0);
                countOfBlackCellMap.put(pos, count + 1);
            }

            if (y - 1 >= 0 && x - 1 >= 0) {
                pos = new Position(y - 1, x - 1);
                count = countOfBlackCellMap.getOrDefault(pos, 0);
                countOfBlackCellMap.put(pos, count + 1);
            }
        }

        long[] answer = new long[5];
        countOfBlackCellMap.forEach((key, value) -> {
            answer[value]++;
        });

        long countOfBlockWithBlackCell = answer[1] + answer[2] + answer[3] + answer[4];
        answer[0] = (long) (m - 1) * (n - 1) - countOfBlockWithBlackCell;
        return answer;
    }
    
    private static class Position {
        private int y;
        private int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Position position = (Position) o;
            return y == position.y && x == position.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}