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
    public boolean isValidBST(TreeNode root) {
       if(root == null) return true;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for(int i=0; i<list.size(); i++) {
            if(i<=0) continue;
            if(list.get(i-1) >= list.get(i)) return false;
        }
        return true;
    }
    
    private static void dfs(TreeNode parent, List<Integer> list) {
        if(parent.left != null) {
            dfs(parent.left, list);
        }
        list.add(parent.val);
        if(parent.right != null){
            dfs(parent.right, list);
        }
    }
}