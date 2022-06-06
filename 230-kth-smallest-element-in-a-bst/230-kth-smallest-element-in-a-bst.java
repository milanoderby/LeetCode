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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> answerList = new ArrayList<>();
        inorderTraversal(root, answerList, k);
        return answerList.get(k - 1);
    }
    
    private static void inorderTraversal(TreeNode root, List<Integer> inorderList, int k) {
        if (inorderList.size() >= k) {
            return;
        }

        if (root.left != null) {
            inorderTraversal(root.left, inorderList, k);
        }

        inorderList.add(root.val);

        if (root.right != null) {
            inorderTraversal(root.right, inorderList, k);
        }
    }
}