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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftTreeQueue = new LinkedList<>();
        Queue<TreeNode> rightTreeQueue = new LinkedList<>();
        leftTreeQueue.add(root.left);
        rightTreeQueue.add(root.right);

        while (!leftTreeQueue.isEmpty() && !rightTreeQueue.isEmpty()) {
            TreeNode leftTreeNode = leftTreeQueue.poll();
            TreeNode rightTreeNode = rightTreeQueue.poll();

            if (Objects.isNull(leftTreeNode) && Objects.isNull(rightTreeNode)) {
                continue;
            }

            if (Objects.isNull(leftTreeNode) || Objects.isNull(rightTreeNode)) {
                return false;
            }

            if (leftTreeNode.val != rightTreeNode.val) {
                return false;
            }

            leftTreeQueue.add(leftTreeNode.left);
            leftTreeQueue.add(leftTreeNode.right);
            rightTreeQueue.add(rightTreeNode.right);
            rightTreeQueue.add(rightTreeNode.left);
        }
        return true;
    }
}