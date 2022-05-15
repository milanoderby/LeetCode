class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSizeOfArray = nums1.length + nums2.length;
        if (totalSizeOfArray % 2 == 1) {
            return getMedianWhichIndexIs(nums1, nums2, totalSizeOfArray / 2 + 1);
        } else {
            int firstMedian = getMedianWhichIndexIs(nums1, nums2, totalSizeOfArray / 2);
            int secondMedian = getMedianWhichIndexIs(nums1, nums2, totalSizeOfArray / 2 + 1);
            return (firstMedian + secondMedian) / 2.0;
        }
    }
    
    private static int getMedianWhichIndexIs(int[] nums1, int[] nums2, int medianIndex) {
        if (nums1.length == 0) {
            return nums2[medianIndex - 1];
        }

        if (nums2.length == 0) {
            return nums1[medianIndex - 1];
        }

        int start = 0;
        int end = nums1.length - 1;

        int minDifferenceToMedianIndex = Integer.MAX_VALUE;
        int median = Integer.MAX_VALUE;

        int countOfElementLessOrEqualThan =
            start + 1 + getCountOfElementLessOrEqualThan(nums2, nums1[start]);
        if (countOfElementLessOrEqualThan == medianIndex) {
            return nums1[start];
        }

        if (countOfElementLessOrEqualThan >= medianIndex
            && minDifferenceToMedianIndex >= countOfElementLessOrEqualThan - medianIndex) {
            median = nums1[start];
        }

        countOfElementLessOrEqualThan =
            end + 1 + getCountOfElementLessOrEqualThan(nums2, nums1[end]);
        if (countOfElementLessOrEqualThan == medianIndex) {
            return nums1[end];
        }

        if (countOfElementLessOrEqualThan >= medianIndex
            && minDifferenceToMedianIndex >= countOfElementLessOrEqualThan - medianIndex) {
            median = nums1[end];
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            countOfElementLessOrEqualThan =
                mid + 1 + getCountOfElementLessOrEqualThan(nums2, nums1[mid]);
            if (countOfElementLessOrEqualThan < medianIndex) {
                start = mid;
            } else if (countOfElementLessOrEqualThan > medianIndex) {
                end = mid;
            } else {
                return nums1[mid];
            }

            if (countOfElementLessOrEqualThan >= medianIndex
                && minDifferenceToMedianIndex >= countOfElementLessOrEqualThan - medianIndex) {
                median = nums1[mid];
            }
        }

        start = 0;
        end = nums2.length - 1;

        countOfElementLessOrEqualThan =
            start + 1 + getCountOfElementLessOrEqualThan(nums1, nums2[start]);
        if (countOfElementLessOrEqualThan == medianIndex) {
            return nums2[start];
        }

        if (countOfElementLessOrEqualThan >= medianIndex
            && minDifferenceToMedianIndex >= countOfElementLessOrEqualThan - medianIndex) {
            median = nums2[start];
        }

        countOfElementLessOrEqualThan =
            end + 1 + getCountOfElementLessOrEqualThan(nums1, nums2[end]);
        if (countOfElementLessOrEqualThan == medianIndex) {
            return nums2[end];
        }

        if (countOfElementLessOrEqualThan >= medianIndex
            && minDifferenceToMedianIndex >= countOfElementLessOrEqualThan - medianIndex) {
            median = nums2[end];
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            countOfElementLessOrEqualThan =
                mid + 1 + getCountOfElementLessOrEqualThan(nums1, nums2[mid]);
            if (countOfElementLessOrEqualThan < medianIndex) {
                start = mid;
            } else if (countOfElementLessOrEqualThan > medianIndex) {
                end = mid;
            } else {
                return nums2[mid];
            }

            if (countOfElementLessOrEqualThan >= medianIndex
                && minDifferenceToMedianIndex >= countOfElementLessOrEqualThan - medianIndex) {
                median = nums2[mid];
            }
        }

        return median;
    }

    private static int getCountOfElementLessOrEqualThan(int[] targetArray, int number) {
        if (targetArray.length == 0) {
            return 0;
        }

        int start = 0;
        int end = targetArray.length - 1;
        if (targetArray[end] <= number) {
            return targetArray.length;
        }

        if (targetArray[start] > number) {
            return 0;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (targetArray[mid] > number) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return end;
    }
}