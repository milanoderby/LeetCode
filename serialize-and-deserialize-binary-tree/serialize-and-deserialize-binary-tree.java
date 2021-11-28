/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (Objects.isNull(root)) {
            return "null";
        }

        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);

        StringJoiner result = new StringJoiner(" ");
        result.add(root.val + "");
        while (!treeNodeQueue.isEmpty()) {
            TreeNode cur = treeNodeQueue.poll();

            if (Objects.isNull(cur.left)) {
                result.add("null");
            } else {
                result.add(cur.left.val + "");
                treeNodeQueue.offer(cur.left);
            }

            if (Objects.isNull(cur.right)) {
                result.add("null");
            } else {
                result.add(cur.right.val + "");
                treeNodeQueue.offer(cur.right);
            }
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        StringTokenizer tokenizer = new StringTokenizer(data);
        TreeNode root = null;
        String nodeValue = tokenizer.nextToken();
        if (nodeValue.equals("null")) {
            return root;
        } else {
            root = new TreeNode(Integer.parseInt(nodeValue));
        }

        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);
        while (tokenizer.hasMoreTokens()) {
            TreeNode cur = treeNodeQueue.poll();

            String leftNodeValue = tokenizer.nextToken();
            if (!leftNodeValue.equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(leftNodeValue));
                treeNodeQueue.offer(cur.left);
            }

            String rightNodeValue = tokenizer.nextToken();
            if (!rightNodeValue.equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(rightNodeValue));
                treeNodeQueue.offer(cur.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));