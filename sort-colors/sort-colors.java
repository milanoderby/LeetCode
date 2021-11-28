class Solution {
    public void sortColors(int[] nums) {
        int index = 0;
        int indexOfZero = 0;
        int indexOfTwo = nums.length - 1;

        while (index <= indexOfTwo) {
            if (nums[index] == 0) {
                swap(indexOfZero, index, nums);
                indexOfZero++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(index, indexOfTwo, nums);
                indexOfTwo--;
            }
        }
    }

    private static void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}