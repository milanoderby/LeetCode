class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        getPermutation(nums, new boolean[6], 0, new ArrayList<>(), answer);
        return answer;
    }
    
    private static void getPermutation(int[] nums, boolean[] isUsed, int cnt, List<Integer> permutation, List<List<Integer>> answer) {
        if (cnt >= nums.length) {
            answer.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                permutation.add(nums[i]);
                getPermutation(nums, isUsed, cnt + 1, permutation, answer);
                permutation.remove(cnt);
                isUsed[i] = false;
            }
        }
    }
}