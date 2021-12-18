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
        return isSame(root.left, root.right);
    }

    private static boolean isSame(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        }

        if (Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }

        if (!Objects.equals(left.val, right.val)) {
            return false;
        }

        boolean result = true;
        result &= isSame(left.left, right.right);
        result &= isSame(left.right, right.left);

        return result;
    }
}