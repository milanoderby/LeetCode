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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode answer = createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return answer;
    }
    
    private static TreeNode createTree(int[] preorder, int startOfPreorder, int endOfPreorder, int[] inorder, int startOfInorder, int endOfInorder) {
        if (startOfPreorder > endOfPreorder) {
            return null;
        }

        TreeNode tree = new TreeNode();
        tree.val = preorder[startOfPreorder];
        if (startOfPreorder == endOfPreorder) {
            return tree;
        }
        
        int target = tree.val;
        int countOfLeftTree = 0;
        for (int index = startOfInorder; index <= endOfInorder; index++) {
            if (inorder[index] == target) {
                break;
            }
            countOfLeftTree++;
        }
        
        tree.left = createTree(preorder, startOfPreorder + 1, startOfPreorder + countOfLeftTree, inorder, startOfInorder, startOfInorder + countOfLeftTree - 1);
        tree.right = createTree(preorder, startOfPreorder + countOfLeftTree + 1, endOfPreorder, inorder, startOfInorder + countOfLeftTree + 1, endOfInorder);
        return tree;
    }
}