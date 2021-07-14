class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        getCombination(candidates, target, 0,0, combination, answer);

        return answer;
    }
    
    private static void getCombination(int[] candidates, int target, int prevIndex, int sum, LinkedList<Integer> combination, List<List<Integer>> answer) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            answer.add(new LinkedList<>(combination));
            return;
        }

        for (int i = prevIndex; i < candidates.length; i++) {
            combination.addLast(candidates[i]);
            getCombination(candidates, target, i,sum + candidates[i], combination, answer);
            combination.removeLast();
        }
    }
}