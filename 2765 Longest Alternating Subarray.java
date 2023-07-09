class Solution {
    public int alternatingSubarray(int[] nums) {
        int maximumLengthOfAlternatingSubarray = -1;
        for (int startIndex = 0; startIndex + 1 < nums.length; startIndex++) {
            int lengthOfAlternatingSubarray = 1;
            int diff = 1;
            for (int index = startIndex; index + 1 < nums.length; index++) {
                if (nums[index] + diff == nums[index + 1]) {
                    lengthOfAlternatingSubarray++;
                } else {
                    break;
                }
                diff *= -1;
            }

            if (lengthOfAlternatingSubarray >= 2) {
                maximumLengthOfAlternatingSubarray = Math.max(maximumLengthOfAlternatingSubarray,
                    lengthOfAlternatingSubarray);
            }
        }

        return maximumLengthOfAlternatingSubarray;
    }
}