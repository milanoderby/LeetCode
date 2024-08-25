class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int y = 0;
        int x = 0;
        for (String command : commands) {
            switch (command) {
                case "UP":
                    y--;
                    break;
                case "DOWN":
                    y++;
                    break;
                case "LEFT":
                    x--;
                    break;
                case "RIGHT":
                    x++;
                    break;
                default:
                    break;
            }
        }
        return n * y + x;
    }
}