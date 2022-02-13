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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (Objects.isNull(root)) {
            return sum;
        }

        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        Queue<Integer> numberQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        numberQueue.add(root.val);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode cur = treeNodeQueue.poll();
            int curNum = numberQueue.poll();
            if (Objects.isNull(cur.left) && Objects.isNull(cur.right)) {
                sum += curNum;
            }

            if (Objects.nonNull(cur.left)) {
                treeNodeQueue.add(cur.left);
                int nextNum = 10 * curNum + cur.left.val;
                numberQueue.add(nextNum);
            }

            if (Objects.nonNull(cur.right)) {
                treeNodeQueue.add(cur.right);
                int nextNum = 10 * curNum + cur.right.val;
                numberQueue.add(nextNum);
            }
        }
        return sum;
    }
}