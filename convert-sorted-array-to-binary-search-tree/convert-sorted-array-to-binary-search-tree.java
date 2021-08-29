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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode answer = createSubtree(nums, 0, nums.length - 1);
        return answer;
    }
    
    public TreeNode createSubtree(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end) / 2;
        TreeNode newTreeNode = new TreeNode(nums[mid]);
        if (start <= mid - 1) {
            newTreeNode.left = createSubtree(nums, start, mid - 1);
        }

        if (mid + 1 <= end) {
            newTreeNode.right = createSubtree(nums, mid + 1, end);
        }
        return newTreeNode;
    }
}