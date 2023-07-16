class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int[][] nums = new int[2][nums1.length];
        System.arraycopy(nums1, 0, nums[0], 0, nums[0].length);
        System.arraycopy(nums2, 0, nums[1], 0, nums[1].length);

        int[][] dp = new int[2][nums1.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int answer = -1;
        for (int arrayNum = 0; arrayNum < nums.length; arrayNum++) {
            for (int startIndex = 0; startIndex < nums[arrayNum].length; startIndex++) {
                answer = Math.max(answer, getMaximumLengthOfSubarray(arrayNum, startIndex, nums, dp));
            }
        }

        return answer;
    }
    
    // startIndex에서 시작하는 non-decreasing subarray의 최대 길이
    // startIndex + 1 에서 시작하는 non-decreasing subarray의 최대 길이 중 더 긴 것을 선택한다.
    private static int getMaximumLengthOfSubarray(int arrayNum, int startIndex, int[][] nums, int[][] dp) {
        int nextIndex = startIndex + 1;
        if (nextIndex >= nums[0].length) {
            return 1;
        }

        if (dp[arrayNum][startIndex] != -1) {
            return dp[arrayNum][startIndex];
        }

        int maximumLengthOfSubarrayStartingFromNextIndex = 0;
        if (nums[arrayNum][startIndex] <= nums[0][nextIndex]) {
            maximumLengthOfSubarrayStartingFromNextIndex = getMaximumLengthOfSubarray(0, nextIndex, nums, dp);
        }

        if (nums[arrayNum][startIndex] <= nums[1][nextIndex]) {
            maximumLengthOfSubarrayStartingFromNextIndex = Math.max(maximumLengthOfSubarrayStartingFromNextIndex, getMaximumLengthOfSubarray(1, nextIndex, nums, dp));
        }

        return dp[arrayNum][startIndex] = maximumLengthOfSubarrayStartingFromNextIndex + 1;
    }
}