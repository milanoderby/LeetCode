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
        
        List<Integer> answer = new ArrayList<>();
        inorder(root, answer);
        return answer;
    }
    
    private static void inorder(TreeNode temp, List<Integer> answer) {
        if(Objects.isNull(temp)) {
            return;
        }
        
        inorder(temp.left, answer);
        answer.add(temp.val);
        inorder(temp.right, answer);
    }
}