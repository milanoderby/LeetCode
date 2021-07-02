class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerSet.contains(nums[i])) {
                integerSet.remove(nums[i]);
            } else {
                integerSet.add(nums[i]);
            }
        }

        int singleNumber = 0;
        for (Integer remainNum : integerSet) {
            singleNumber = remainNum;
        }
        return singleNumber;
    }
}