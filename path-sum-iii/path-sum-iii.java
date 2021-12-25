/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static int countOfPath;
    public int pathSum(TreeNode root, int targetSum) {
        countOfPath = 0;
        dfs(root, 0, new ArrayList<>(Arrays.asList(0L)), targetSum);
        return countOfPath;
    }
    
    private static void dfs(TreeNode node, long sum, List<Long> partSumList, int targetSum) {
        if (Objects.isNull(node)) {
            return;
        }

        sum += node.val;
        for (Long partSum : partSumList) {
            if (sum - partSum == targetSum) {
                countOfPath++;
            }
        }

        partSumList.add(sum);
        dfs(node.left, sum, partSumList, targetSum);
        dfs(node.right, sum, partSumList, targetSum);
        partSumList.remove(partSumList.size() - 1);
    }
}