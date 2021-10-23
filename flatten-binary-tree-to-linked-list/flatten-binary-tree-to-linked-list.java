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
    public void flatten(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        
        if (Objects.nonNull(root.left)) {
            flatten(root.left);
        }

        if (Objects.nonNull(root.right)) {
            flatten(root.right);
        }
        
        TreeNode newRight = root.right;
        root.right = root.left;
        root.left = null;
        
        TreeNode temp = root;
        while (Objects.nonNull(temp.right)) {
            temp = temp.right;
        }
        temp.right = newRight;
    }
}