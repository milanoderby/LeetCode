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
        List<Integer> arrayList = new ArrayList<>();
        getCountOfSubTree(root, arrayList, 0);

        return arrayList.get(k - 1);
    }
    
    private static int getCountOfSubTree(TreeNode root, List<Integer> arrayList, int countOfSubTree) {
        if (Objects.isNull(root)) {
            return countOfSubTree;
        }

        if (Objects.nonNull(root.left)) {
            countOfSubTree += getCountOfSubTree(root.left, arrayList, countOfSubTree);
        }
        arrayList.add(root.val);

        if (Objects.nonNull(root.right)) {
            countOfSubTree += getCountOfSubTree(root.right, arrayList, countOfSubTree);
        }

        return countOfSubTree;
    }
}