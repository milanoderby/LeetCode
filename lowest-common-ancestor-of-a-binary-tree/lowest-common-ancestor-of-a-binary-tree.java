/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        Map<Integer, TreeNode> parentMap = new HashMap<>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            TreeNode left = cur.left;
            if (Objects.nonNull(left)) {
                parentMap.put(left.val, cur);
                queue.offer(left);
            }

            TreeNode right = cur.right;
            if (Objects.nonNull(right)) {
                parentMap.put(right.val, cur);
                queue.offer(right);
            }
        }

        Set<Integer> parentOfP = new HashSet<>();
        TreeNode temp = p;
        while (temp != null) {
            parentOfP.add(temp.val);
            temp = parentMap.getOrDefault(temp.val, null);
        }

        TreeNode answer = null;
        temp = q;
        while (temp != null) {
            if (parentOfP.contains(temp.val)) {
                answer = temp;
                break;
            }
            temp = parentMap.getOrDefault(temp.val, null);
        }

        return answer;
    }
}