class Solution {
    public int maxSubArray(int[] nums) {
        int partSum = 0;
        int minPartSum = 0;
        int sumOfMaxSubArray = nums[0];
        for (int i = 0; i < nums.length; i++) {
            partSum += nums[i];
            sumOfMaxSubArray = Math.max(sumOfMaxSubArray, partSum - minPartSum);

            minPartSum = Math.min(minPartSum, partSum);
        }
        return sumOfMaxSubArray;
    }
}