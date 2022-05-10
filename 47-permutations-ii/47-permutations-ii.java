class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<String> uniquePermutationSet = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        getPermutation(0, used, nums, new ArrayList<>(), answer, uniquePermutationSet);
        return answer;
    }
    
    private static void getPermutation(int index, boolean[] used, int[] nums, List<Integer> permutation, List<List<Integer>> answer, Set<String> uniquePermutationSet) {
        if (index >= nums.length) {
            String permutationString = permutation.toString();
            if (!uniquePermutationSet.contains(permutationString)) {
                uniquePermutationSet.add(permutationString);
                answer.add(new ArrayList<>(permutation));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            
            permutation.add(nums[i]);
            used[i] = true;
            getPermutation(index + 1, used, nums, permutation, answer, uniquePermutationSet);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }
}