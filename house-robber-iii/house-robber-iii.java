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
    public int rob(TreeNode root) {
        MaxMoney maxMoney = robMoney(root);
        return Math.max(maxMoney.ifRoobed, maxMoney.unlessRoobed);
    }
    
    private static class MaxMoney {
        int ifRoobed;
        int unlessRoobed;
    }

    private static MaxMoney robMoney(TreeNode root) {
        if (Objects.isNull(root)) {
            return new MaxMoney();
        }

        MaxMoney maxMoneyOfLeft = robMoney(root.left);
        MaxMoney maxMoneyOfRight = robMoney(root.right);

        MaxMoney maxMoneyOfThisHouse = new MaxMoney();
        maxMoneyOfThisHouse.ifRoobed = root.val + maxMoneyOfLeft.unlessRoobed + maxMoneyOfRight.unlessRoobed;
        maxMoneyOfThisHouse.unlessRoobed = Math.max(maxMoneyOfLeft.ifRoobed, maxMoneyOfLeft.unlessRoobed) + Math.max(maxMoneyOfRight.ifRoobed, maxMoneyOfRight.unlessRoobed);

        return maxMoneyOfThisHouse;
    }
}