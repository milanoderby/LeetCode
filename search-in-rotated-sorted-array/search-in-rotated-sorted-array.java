class Solution {
    public int search(int[] nums, int target) {
        if (nums[0] <= nums[nums.length - 1]) {
            int index = Arrays.binarySearch(nums, target);
            return index < 0 ? -1 : index;
        }

        int mid = getMid(nums);
        int frontIndex = Arrays.binarySearch(nums, 0, mid + 1, target);
        if (frontIndex >= 0) {
            return frontIndex;
        }

        int rearIndex = Arrays.binarySearch(nums,mid + 1, nums.length, target);
        if (rearIndex >= 0) {
            return rearIndex;
        }
        return -1;
    }
    
    private static int getMid(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;

        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[start] < nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}