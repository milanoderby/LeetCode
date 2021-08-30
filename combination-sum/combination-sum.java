class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        getCombination(candidates, 0, 0, target, new ArrayList<>(), answer);
        return answer;
    }
    
    private static void getCombination(int[] candidates, int index, int sum, int target, List<Integer> combination, List<List<Integer>> answer) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            answer.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            combination.add(candidates[i]);
            getCombination(candidates, i, sum + candidates[i], target, combination, answer);
            combination.remove(combination.size() - 1);
        }
    }
}