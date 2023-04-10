class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        // 1,3,6,8
        // (1-1) + (3-1) + (6-1) + (8-1) = 0 + 2 + 5 + 7 = 14
        // (1-5) + (3-5) + (6-5) + (8-5) = -4 + -2 + 1 + 3 = 10

        // k <= 1 일 때
        // nums의 합 - (4 * k)

        // 1 < k <=3 일 때
        // (k - nums[0]) + (nums[1] - k) + (nums[2] - k) + (nums[3] - k)
        // ((k보다 크거나 같은 nums[element]의 갯수) - k보다 작은 nums[element]의 갯수)) * k
        // (k보다 크거나 같은 nums[element]들의 합) - (k보다 작은 nums[element]들의 합)

        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        long tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            prefixSum[i] = tempSum;
        }

        List<Long> answerList = new ArrayList<>();
        int totalCountOfNumber = nums.length;
        for (int k : queries) {
            int countOfNumberLessThanK = getCountOfNumberLessThanK(nums, k);
            int countOfNumberGreaterThanOrEqualToK = totalCountOfNumber - countOfNumberLessThanK;
            long answer = (long) (countOfNumberLessThanK - countOfNumberGreaterThanOrEqualToK) * k;

            long totalSumOfNumber = prefixSum[prefixSum.length - 1];
            long sumOfNumberLessThanK = countOfNumberLessThanK >= 1 ? prefixSum[countOfNumberLessThanK - 1] : 0;
            answer += totalSumOfNumber - sumOfNumberLessThanK;
            answer -= sumOfNumberLessThanK;

            answerList.add(answer);
        }
        return answerList;
    }
    
    // nums 배열의 숫자들 중에서 k보다 작은 숫자의 개수
    // 0 ~ N개 까지 가능
    private static int getCountOfNumberLessThanK(int[]nums, int k) {
        if (nums[0] >= k) {
            return 0;
        }

        if (nums[nums.length - 1] < k) {
            return nums.length;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start + 1;
    }
}