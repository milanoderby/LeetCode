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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answerList = new ArrayList<>();
        inorderPrint(root, answerList);
        return answerList;
    }
    
    private static void inorderPrint(TreeNode node, List<Integer> answerList) {
        if(Objects.isNull(node)) {
            return;
        }
        
        inorderPrint(node.left, answerList);
        answerList.add(node.val);
        inorderPrint(node.right, answerList);
    }
}