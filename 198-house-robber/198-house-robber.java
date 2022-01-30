class Solution {
    public int rob(int[] nums) {
        int[][] maxAmount = new int[2][nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxAmount[0][i] = -1;
            maxAmount[1][i] = -1;
        }

        return Math.max(getMaxAmount(nums, maxAmount, 0, true), getMaxAmount(nums, maxAmount,0, false));
    }
    
    private static int getMaxAmount(int[] houses, int[][] maxAmount, int indexOfHouse, boolean isRobbed) {
        if (indexOfHouse >= houses.length) {
            return 0;
        }
        
        int robbedIndex = isRobbed ? 1: 0;
        if (maxAmount[robbedIndex][indexOfHouse] != -1) {
            return maxAmount[robbedIndex][indexOfHouse];
        }

        if (isRobbed) {
            return maxAmount[robbedIndex][indexOfHouse] = houses[indexOfHouse] + getMaxAmount(houses, maxAmount, indexOfHouse + 1, false);
        }

        return maxAmount[robbedIndex][indexOfHouse] = Math.max(getMaxAmount(houses, maxAmount, indexOfHouse + 1, false), getMaxAmount(houses, maxAmount, indexOfHouse + 1, true));
    }
}