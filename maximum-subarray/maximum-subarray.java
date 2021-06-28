class Solution {
    public int maxSubArray(int[] nums) {
        long[] partSum = new long[nums.length + 1];
        partSum[0] = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            partSum[i + 1] = sum;
        }

        long answer = Long.MIN_VALUE;
        long minPartSum = 0;
        for (int i = 0; i < nums.length; i++) {
            minPartSum = Math.min(minPartSum, partSum[i]);
            answer = Math.max(partSum[i + 1] - minPartSum, answer);
        }
        return (int)answer;
    }
}