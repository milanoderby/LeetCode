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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        traversal(root, 0, answer);
        return answer;
    }
    
    private static void traversal(TreeNode treeNode, int depth, List<Integer> answer) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        
        if (depth >= answer.size()) {
            answer.add(treeNode.val);
        }
        
        traversal(treeNode.right, depth + 1, answer);
        traversal(treeNode.left, depth + 1, answer);
    }
}