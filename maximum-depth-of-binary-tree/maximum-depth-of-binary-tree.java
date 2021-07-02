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
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int maxDepth = -1;
        Queue<TreeNode> treeQueue = new LinkedList<>();
        Queue<Integer> treeDepth = new LinkedList<>();
        treeQueue.add(root);
        treeDepth.add(1);
        while (!treeQueue.isEmpty()) {
            TreeNode treeNode = treeQueue.poll();
            int depth = treeDepth.poll();
            maxDepth = Math.max(maxDepth, depth);

            if (Objects.nonNull(treeNode.left)) {
                treeQueue.add(treeNode.left);
                treeDepth.add(depth + 1);
            }

            if (Objects.nonNull(treeNode.right)) {
                treeQueue.add(treeNode.right);
                treeDepth.add(depth + 1);
            }
        }

        return maxDepth;
    }
}