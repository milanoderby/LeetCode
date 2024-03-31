class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long answer = 0;
        int indexOfOutRangeNumber = -1;
        int indexOfMinK = -1;
        int indexOfMaxK = -1;

        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (num == minK) {
                indexOfMinK = index;
            }

            if (num == maxK) {
                indexOfMaxK = index;
            }

            if (num < minK || num > maxK) {
                indexOfOutRangeNumber = index;
            }

            if (indexOfMinK != -1 && indexOfMaxK != -1) {
                int startIndexOfSubArray = Math.min(indexOfMinK, indexOfMaxK);
                if (indexOfOutRangeNumber < startIndexOfSubArray) {
                    answer += startIndexOfSubArray - indexOfOutRangeNumber;
                }
            }
        }
        return answer;
    }
}