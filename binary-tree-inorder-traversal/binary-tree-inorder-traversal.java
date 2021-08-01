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
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);

        while (!treeNodes.isEmpty()) {
            TreeNode cur = treeNodes.peek();
            if (Objects.nonNull(cur)) {
                treeNodes.push(cur.left);
                continue;
            }
            treeNodes.pop();

            if (!treeNodes.isEmpty()) {
                TreeNode parent = treeNodes.pop();
                answer.add(parent.val);
                treeNodes.push(parent.right);
            }
        }
        return answer;
    }
}
