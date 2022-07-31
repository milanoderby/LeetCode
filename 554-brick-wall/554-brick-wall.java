class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int widthOfWall = 0;
        Map<Integer, Integer> countOfPassableBrickMap = new HashMap<>();
        for (List<Integer> brick : wall) {
            int indexOfBrick = 0;
            for (Integer widthOfBrick : brick) {
                indexOfBrick += widthOfBrick;
                countOfPassableBrickMap.compute(indexOfBrick,
                    (key, previousCount) -> previousCount == null ? 1 : previousCount + 1);
            }
            widthOfWall = indexOfBrick;
        }

        int maximumCountOfPassableBrick = 0;
        for (Integer indexOfBrick : countOfPassableBrickMap.keySet()) {
            if (indexOfBrick == 0 || indexOfBrick == widthOfWall) {
                continue;
            }
            maximumCountOfPassableBrick = Math.max(maximumCountOfPassableBrick,
                countOfPassableBrickMap.get(indexOfBrick));
        }
        return wall.size() - maximumCountOfPassableBrick;
    }
}