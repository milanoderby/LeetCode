class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target);
        return new int[]{lower, upper};
    }
    
    private static int lowerBound(int nums[], int target) {
        if (nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length;
        if (target == nums[start]) {
            return start;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid - 1] < target && nums[mid] >= target) {
                return nums[mid] == target? mid : -1;
            } else if (target <= nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }

    private static int upperBound(int nums[], int target) {
        if (nums.length == 0) {
            return -1;
        }

        int start = -1;
        int end = nums.length - 1;
        if (target == nums[end]) {
            return end;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target && nums[mid + 1] > target) {
                return nums[mid] == target? mid : -1;
            } else if (target >= nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}