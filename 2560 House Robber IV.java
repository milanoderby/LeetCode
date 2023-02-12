class Solution {    
    public int minCapability(int[] nums, int k) {
        int start = 0;
        int end = 1_000_000_000;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (countOfNumberBiggerThanPivot(nums, mid) >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }
    
    private static int countOfNumberBiggerThanPivot(int[] nums, int pivot) {
        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] <= pivot) {
                count++;
                index++;
            }
        }
        return count;
    }
}