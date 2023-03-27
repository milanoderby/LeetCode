class Solution {
    public boolean checkValidGrid(int[][] grid) {
        Position[] positions = new Position[grid.length * grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int index = grid[i][j];
                positions[index] = new Position(i, j);
            }
        }

        Position startPosition = positions[0];
        if (!(startPosition.y == 0 && startPosition.x == 0)) {
            return false;
        }

        for (int i = 1; i < positions.length; i++) {
            Position prevPosition = positions[i - 1];
            Position nextPosition = positions[i];

            int diffOfY = Math.abs(prevPosition.y - nextPosition.y);
            int diffOfX = Math.abs(prevPosition.x - nextPosition.x);

            if (!((diffOfX == 1 && diffOfY == 2) || (diffOfX == 2 && diffOfY == 1))) {
                return false;
            }
        }
        return true;
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