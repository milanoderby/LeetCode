class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        makeSubset(0, nums, new ArrayList<>(), answer);
        return answer;
    }
    
    private static void makeSubset(int index, int[] nums, List<Integer> subset, List<List<Integer>> answer) {
        if (index >= nums.length) {
            answer.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        makeSubset(index + 1, nums, subset, answer);
        subset.remove(subset.size() - 1);
        makeSubset(index + 1, nums, subset, answer);
    }
}