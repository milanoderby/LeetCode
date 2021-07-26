class Solution {
    public int singleNumber(int[] nums) {
        int bitWiseResult = 0;
        for (int i = 0; i < nums.length; i++) {
            bitWiseResult ^= nums[i];
        }

        return bitWiseResult;
    }
}