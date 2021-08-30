class Solution {
    private static List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        getCombination(candidates, 0, 0, target, new Stack<>());
        return answer;
    }
    
    private static void getCombination(int[] candidates, int index, int sum, int target, Stack<Integer> combination) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            answer.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            combination.push(candidates[i]);
            getCombination(candidates, i, sum + candidates[i], target, combination);
            combination.pop();
        }
    }
}