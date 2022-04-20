class Solution {
    public int lengthOfLIS(int[] nums) {
        // 길이가 N인 LIS중 가장 작은 숫자
        // 단조증가하는 배열이므로 이분탐색 활용 가능
        List<Integer> numberOfLISWithLength = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberOfLISWithLength.isEmpty()) {
                numberOfLISWithLength.add(nums[i]);
                continue;
            }
            int start = 0;
            int minNumber = numberOfLISWithLength.get(start);
            if (minNumber >= nums[i]) {
                numberOfLISWithLength.set(0, nums[i]);
                continue;
            }

            int end = numberOfLISWithLength.size() - 1;
            int maxNumber = numberOfLISWithLength.get(end);
            if (maxNumber < nums[i]) {
                numberOfLISWithLength.add(nums[i]);
                continue;
            }

            while (start + 1 < end) {
                int mid = (start + end) / 2;
                int number = numberOfLISWithLength.get(mid);
                if (nums[i] > number) {
                    start = mid;
                } else if (nums[i] <= number) {
                    end = mid;
                }
            }
            numberOfLISWithLength.set(end, nums[i]);
        }
        return numberOfLISWithLength.size();
    }
}