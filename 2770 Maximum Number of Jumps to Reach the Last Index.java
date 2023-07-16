class Solution {
    public int maximumJumps(int[] nums, int target) {
        int[] maxJumpCount = new int[nums.length];
        Arrays.fill(maxJumpCount, -1);
        maxJumpCount[0] = 0;

        for (int src = 0; src < nums.length; src++) {
            if (maxJumpCount[src] == -1) {
                continue;
            }
            
            for (int dest = src + 1; dest < nums.length; dest++) {
                if (Math.abs(nums[src] - nums[dest]) <= target) {
                    maxJumpCount[dest] = Math.max(maxJumpCount[dest], maxJumpCount[src] + 1);
                }
            }
        }
        return maxJumpCount[nums.length - 1];
    }
}