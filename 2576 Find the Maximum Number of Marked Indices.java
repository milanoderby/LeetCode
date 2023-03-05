class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int midIndex = nums.length / 2;
        int right = midIndex;

        int answer = 0;
        while (left < midIndex && right < nums.length) {
            if (2 * nums[left] <= nums[right]) {
                answer+=2;
                left++;
            }
            right++;
        }
        return answer;
    }
}