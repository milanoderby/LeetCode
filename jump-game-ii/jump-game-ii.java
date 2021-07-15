class Solution {
    public int jump(int[] nums) {
        int[] minDist = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        for (int cur = 0; cur < nums.length; cur++) {
            int maximumJump = nums[cur];
            for (int jump = 1; jump <= maximumJump; jump++) {
                int next = cur + jump;
                if (next >= nums.length) {
                    continue;
                }

                if (minDist[next] > minDist[cur] + 1) {
                    minDist[next] = minDist[cur] + 1;
                }
            }
        }
        return minDist[nums.length - 1];
    }
}