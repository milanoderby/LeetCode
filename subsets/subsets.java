class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        getSubset(0, nums, new ArrayList<>(), answer);
        return answer;
    }
    
    private static void getSubset(int index, int[] nums, List<Integer> subset, List<List<Integer>> answer) {
        if (index >= nums.length) {
            answer.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        getSubset(index + 1, nums, subset, answer);
        subset.remove(subset.size() - 1);
        getSubset(index + 1, nums, subset, answer);
    }
}