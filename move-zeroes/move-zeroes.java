class Solution {
    public void moveZeroes(int[] nums) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < nums.length) {
            if (nums[index1] == 0) {
                index1++;
            } else {
                nums[index2] = nums[index1];
                index1++;
                index2++;
            }
        }
        
        while (index2 < nums.length) {
            nums[index2] = 0;
            index2++;
        }
    }
}