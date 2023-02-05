class Solution {
    public long countQuadruplets(int[] nums) {
        long[] dp = new long[nums.length];
        long answer = 0;
        for (int k = 0; k < nums.length; k++) {
            int countOfSmallNumber = 0;
            for (int index = 0; index < k; index++) {
                if (nums[index] < nums[k]) {
                    // nums[k] 보다 작은 수의 갯수를 셉니다.
                    // 여기서 k는 (i, j, k) 의 가장 뒤에 오는 index를 의미합니다.
                    countOfSmallNumber++;

                    // 만약 (j < k < l) (nums[k] < nums[j] < nums[l])를 만족하는 l을 구한다면, 이를 이용하여 answer를 갱신합니다.
                    // 여기서, nums[k] < nums[j]는 이미 dp조건에 의해 자명합니다.
                    // 또한 dp의 조건과 반복문의 순서에 의해 dp[j] 는 현재 j < k < l을 만족합니다.
                    int j = index;
                    int l = k;
                    answer += dp[j];
                } else {
                    // 만약 (i < j < k) (nums[i] < nums[k] < nums[j])를 만족하는 j값을 구한다면 이를 이용하여 dp[j]를 갱신합니다.
                    // dp[j]: (i < j < k) (nums[i] < nums[k] < nums[j])를 만족하면서, 조합의 갯수
                    int j = index;
                    dp[j] += countOfSmallNumber;
                }
            }
        }
        return answer;
    }
}