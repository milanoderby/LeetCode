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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        Queue<Integer> treeNodeHeightQueue = new ArrayDeque<>();
        
        if (Objects.nonNull(root)) {
            treeNodeQueue.offer(root);
            treeNodeHeightQueue.offer(0);
        }

        while (!treeNodeQueue.isEmpty()) {
            TreeNode treeNode = treeNodeQueue.poll();
            int height = treeNodeHeightQueue.poll();
            
            int value = treeNode.val;
            if (answer.size() == height) {
                answer.add(new ArrayList<>(Arrays.asList(value)));
            } else {
                List<Integer> temp = answer.get(height);
                temp.add(value);
            }

            if (Objects.nonNull(treeNode.left)) {
                treeNodeQueue.offer(treeNode.left);
                treeNodeHeightQueue.offer(height + 1);
            }
            
            if (Objects.nonNull(treeNode.right)) {
                treeNodeQueue.offer(treeNode.right);
                treeNodeHeightQueue.offer(height + 1);
            }
        }
        
        return answer;
    }
}