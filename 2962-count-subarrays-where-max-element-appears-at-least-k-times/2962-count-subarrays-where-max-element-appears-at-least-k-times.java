class Solution {
    public long countSubarrays(int[] nums, int k) {
        long countOfSubArray = 0;
        int maxElement = Arrays.stream(nums).max().getAsInt();
        List<Integer> indexListOfMax = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxElement) {
                indexListOfMax.add(i);
            }

            if (indexListOfMax.size() >= k) {
                int maxStartIndexOfSubArray = indexListOfMax.size() - k;
                countOfSubArray += indexListOfMax.get(maxStartIndexOfSubArray) + 1;
            }
        }
        return countOfSubArray;
    }
}