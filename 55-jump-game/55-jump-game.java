class Solution {
    public boolean canJump(int[] nums) {
        int maximumIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index > maximumIndex) {
                break;
            }
            
            maximumIndex = Math.max(maximumIndex, index + nums[index]);
            if (maximumIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}