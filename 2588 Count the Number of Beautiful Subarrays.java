class Solution {
    public long beautifulSubarrays(int[] nums) {
        // 1. 각 숫자들의 0bit ~ 19bit까지의 개수를 각각 구합니다.
        // 2. 각 bit의 개수를 기준으로 prefix sum을 구합니다.
        // 3. 각 bit의 개수 prefix sum은 그 자체의 값보다 bit의 개수가 짝수개/홀수개인지가 더 중요합니다.
        // 4. 각 bit의 개수 prefix sum을 (각 bit의 개수가 짝수개인지 / 홀수개인지)에 대한 구성비로 변경합니다.
        // 5. 각 prefix sum에 대해서 동일한 (bit의 개수 구성)을 가지는 숫자가 존재하다면, 이들 끼리 조합하면 beautiful subarray를 만들 수 있습니다.

        int maximumBit = 20;
        int[][] bitCount = new int[nums.length][maximumBit];

        Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
        prefixSumCountMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            int bitCountOfPrefixSum = 0;
            for (int j = 0; j < maximumBit; j++) {
                if (i > 0) {
                    bitCount[i][j] = bitCount[i - 1][j];
                }

                if ((number & (1 << j)) > 0) {
                    bitCount[i][j]++;
                    bitCount[i][j] %= 2;
                }

                if (bitCount[i][j] == 1) {
                    bitCountOfPrefixSum += (1 << j);
                }
            }

            int count = prefixSumCountMap.getOrDefault(bitCountOfPrefixSum, 0);
            prefixSumCountMap.put(bitCountOfPrefixSum, count + 1);
        }

        long answer = 0;
        for (Integer countOfBitCountOfPrefixSum : prefixSumCountMap.values()) {
            answer += (long) countOfBitCountOfPrefixSum * (countOfBitCountOfPrefixSum - 1) / 2;
        }
        return answer;
    }
}