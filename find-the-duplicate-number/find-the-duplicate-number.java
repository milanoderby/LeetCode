class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] appeared = new boolean[nums.length];
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (appeared[nums[i]]) {
                answer = nums[i];
                break;
            }
            appeared[nums[i]] = true;
        }
        return answer;
    }
}