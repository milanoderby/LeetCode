class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{getLowerBound(nums, target), getUpperBound(nums, target)};
    }
    
    private static int getLowerBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        if (target < nums[start] || target > nums[end]) {
            return -1;
        }

        if (target == nums[start]) {
            return start;
        }

        int lowerBound = -1;
        if (target == nums[end]) {
            lowerBound = end;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                lowerBound = mid;
                end = mid;
            }
        }

        return lowerBound;
    }

    private static int getUpperBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        if (target < nums[start] || target > nums[end]) {
            return -1;
        }

        if (target == nums[end]) {
            return end;
        }

        int upperBound = -1;
        if (target == nums[start]) {
            upperBound = start;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                upperBound = mid;
                start = mid;
            }
        }

        return upperBound;
    }
}