class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= n; i--) {
            nums1[i] = nums1[i - n];
        }

        int index1 = n;
        int index2 = 0;
        int index3 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                nums1[index3] = nums1[index1];
                index1++;
            } else {
                nums1[index3] = nums2[index2];
                index2++;
            }
            index3++;
        }

        if (index1 < nums1.length) {
            while (index1 < nums1.length) {
                nums1[index3] = nums1[index1];
                index1++;
                index3++;
            }
        } else {
            while (index2 < nums2.length) {
                nums1[index3] = nums2[index2];
                index2++;
                index3++;
            }
        }
    }
}