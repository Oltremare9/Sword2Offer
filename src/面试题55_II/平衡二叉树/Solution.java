package 面试题55_II.平衡二叉树;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return res;
    }

    private int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (Math.abs(left - right) > 1)
            res = false;
        return Math.max(left, right) + 1;
    }
}