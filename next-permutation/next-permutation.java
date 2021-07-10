class Solution {
    public void nextPermutation(int[] nums) {
        boolean isDescendingOrder = true;
        int indexToChange = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                indexToChange = i - 1;
                isDescendingOrder = false;
                break;
            }
        }

        if (!isDescendingOrder) {
            int changedNum = Integer.MAX_VALUE;
            int indexOfChangedNum = -1;
            for (int i = indexToChange + 1; i < nums.length; i++) {
                if (nums[i] > nums[indexToChange] && nums[i] < changedNum) {
                    changedNum = nums[i];
                    indexOfChangedNum = i;
                }
            }

            int temp = nums[indexToChange];
            nums[indexToChange] = nums[indexOfChangedNum];
            nums[indexOfChangedNum] = temp;
        }

        Arrays.sort(nums, indexToChange + 1, nums.length);
    }
}