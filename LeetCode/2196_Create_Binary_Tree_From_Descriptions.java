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
    public TreeNode createBinaryTree(int[][] A) {
        Map<Integer, TreeNode> nodes = new HashMap<>(A.length + 1, 1);
        int root = 0;

        for (int[] d : A) {
            int x = d[0], y = d[1];
            if (!nodes.containsKey(x)) {
                nodes.put(x, new TreeNode(x));
                root ^= x;
            }
            if (!nodes.containsKey(y)) {
                nodes.put(y, new TreeNode(y));
                root ^= y;
            }
            if (d[2] == 1) {
                nodes.get(x).left = nodes.get(y);
            } else {
                nodes.get(x).right = nodes.get(y);
            }
            root ^= y;
        }

        return nodes.get(root);
    }
}
