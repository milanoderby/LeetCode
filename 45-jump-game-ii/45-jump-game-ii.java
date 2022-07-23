class Solution {
    public int jump(int[] nums) {
        int[] countOfJump = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            countOfJump[i] = Integer.MAX_VALUE;
        }

        countOfJump[0] = 0;
        for (int src = 0; src < nums.length; src++) {
            for (int jump = 1; jump <= nums[src]; jump++) {
                int dest = src + jump;
                if (dest >= nums.length) {
                    continue;
                }
                
                countOfJump[dest] = Math.min(countOfJump[dest], countOfJump[src] + 1);
            }
        }
        
        return countOfJump[nums.length - 1];
    }
}