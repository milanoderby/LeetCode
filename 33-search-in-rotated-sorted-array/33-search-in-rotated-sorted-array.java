class Solution {
    public int search(int[] nums, int target) {
        int rotationPivotIndex = findRotationPivotIndex(nums);
        if (rotationPivotIndex == -1) {
            return getNumberIndex(nums, 0, nums.length - 1, target);
        }
        
        int answer =  getNumberIndex(nums, 0, rotationPivotIndex, target);
        if (answer != -1) {
            return answer;
        }
        
        return getNumberIndex(nums, rotationPivotIndex + 1, nums.length - 1, target);
    }
    
    private static int findRotationPivotIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] <= nums[end]) {
            return -1;
        }

        int mid = (start + end) / 2;
        while (start + 1 < end) {
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[start] < nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }

            mid = (start + end) / 2;
        }

        return mid;
    }

    private static int getNumberIndex(int[] nums, int start, int end, int target) {
        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        if (target < nums[start] || nums[end] < target) {
            return -1;
        }

        int mid = (start + end) / 2;
        while (start + 1 < end) {
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                end = mid;
            }

            mid = (start + end) / 2;
        }

        return -1;
    }
}