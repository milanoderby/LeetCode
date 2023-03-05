class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        int tempSum = 0;
        for (int i = 1; i < nums.length; i++) {
            tempSum += nums[i - 1];
            leftSum[i] = tempSum;
        }

        tempSum = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            tempSum += nums[i + 1];
            rightSum[i] = tempSum;
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }
}