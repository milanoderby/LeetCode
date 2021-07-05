class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] isExistingNum = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            isExistingNum[nums[i]] = true;
        }

        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!isExistingNum[i]) {
                disappearedNumbers.add(i);
            }
        }
        return disappearedNumbers;
    }
}