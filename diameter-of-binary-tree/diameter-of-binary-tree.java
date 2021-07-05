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
    private static int answer;
    public int diameterOfBinaryTree(TreeNode root) {
        answer = Integer.MIN_VALUE;
        getDepth(root);
        return answer;
    }
    
    private static int getDepth(TreeNode node) {
        int leftDepth = 0;
        if (Objects.nonNull(node.left)) {
            leftDepth = getDepth(node.left) + 1;
        }

        int rightDepth = 0;
        if (Objects.nonNull(node.right)) {
            rightDepth = getDepth(node.right) + 1;
        }

        answer = Math.max(answer, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }
}