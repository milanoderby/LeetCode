class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums.length < 3) {
            return answer;
        }

        Arrays.sort(nums);
        int prevNum1 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (prevNum1 == nums[i]) {
                continue;
            }

            int startIndex = i + 1;
            int endIndex = nums.length - 1;
            int targetNum = -1 * nums[i];

            int prevNum2 = Integer.MIN_VALUE;
            while (startIndex < endIndex) {
                if (prevNum2 == nums[startIndex]) {
                    startIndex++;
                    continue;
                }

                if (nums[startIndex] + nums[endIndex] == targetNum) {
                    answer.add(Arrays.asList(nums[i], nums[startIndex], nums[endIndex]));
                    prevNum2 = nums[startIndex];
                    startIndex++;
                } else if (nums[startIndex] + nums[endIndex] < targetNum) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }

            prevNum1 = nums[i];
        }
        return answer;
    }
}