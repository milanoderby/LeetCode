class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i <= maxReach; i++) {
            if (maxReach >= nums.length - 1) {
                return true;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return false;
    }
}