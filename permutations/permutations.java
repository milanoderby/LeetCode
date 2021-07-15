class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        getPermutation(nums, new boolean[6], 0, new LinkedList<>(), answer);
        for (List<Integer> integerList : answer) {
            for (Integer integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        return answer;
    }
    
    private static void getPermutation(int[] nums, boolean[] isUsed, int cnt, LinkedList<Integer> permutation, List<List<Integer>> answer) {
        if (cnt >= nums.length) {
            answer.add(new LinkedList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                permutation.addLast(nums[i]);
                getPermutation(nums, isUsed, cnt + 1, permutation, answer);
                permutation.removeLast();
                isUsed[i] = false;
            }
        }
    }
}