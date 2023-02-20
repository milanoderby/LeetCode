class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long answer = 0;

        for (int i = 0; i + 1 < nums.length; i++) {
            int indexOfBiggerOrEqualThan = getIndexOfBiggerOrEqualThan(nums, lower - nums[i], i + 1, nums.length - 1);
            int indexOfLessOrEqualThan = getIndexOfLessOrEqualThan(nums, upper - nums[i], i + 1, nums.length - 1);

            if (indexOfBiggerOrEqualThan == -1 || indexOfLessOrEqualThan == -1) {
                continue;
            }
            if (indexOfLessOrEqualThan >= indexOfBiggerOrEqualThan) {
                answer += indexOfLessOrEqualThan - indexOfBiggerOrEqualThan + 1;
            }
        }
        return answer;
    }
    
    private static int getIndexOfBiggerOrEqualThan(int[] nums, int lower, int startIndex, int endIndex) {
        if (lower <= nums[startIndex]) {
            return startIndex;
        }

        if (nums[endIndex] < lower) {
            return -1;
        }

        while (startIndex + 1 < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (lower <= nums[mid]) {
                endIndex = mid;
            } else {
                startIndex = mid;
            }
        }
        return endIndex;
    }

    private static int getIndexOfLessOrEqualThan(int[] nums, int upper, int startIndex, int endIndex) {
        if (nums[endIndex] <= upper) {
            return endIndex;
        }

        if (nums[startIndex] > upper) {
            return -1;
        }

        while (startIndex + 1 < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (nums[mid] <= upper) {
                startIndex = mid;
            } else {
                endIndex = mid;
            }
        }
        return startIndex;
    }
}