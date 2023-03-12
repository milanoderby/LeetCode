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
    public long kthLargestLevelSum(TreeNode root, int k) {
        long[] sumOfLevel = new long[100000];
        int largestLevel = 0;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        Queue<Integer> levelQueue = new ArrayDeque<>();
        levelQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int currentLevel = levelQueue.poll();

            largestLevel = Math.max(largestLevel, currentLevel);
            sumOfLevel[currentLevel] += node.val;

            if (node.left != null) {
                nodeQueue.add(node.left);
                levelQueue.add(currentLevel + 1);
            }

            if (node.right != null) {
                nodeQueue.add(node.right);
                levelQueue.add(currentLevel + 1);
            }
        }

        List<Long> sumList = new ArrayList<>();
        for (int i = 0; i <= largestLevel; i++) {
            sumList.add(sumOfLevel[i]);
        }

        if (largestLevel + 1 < k) {
            return -1;
        }

        Collections.sort(sumList, Comparator.reverseOrder());
        return sumList.get(k - 1);
    }
}