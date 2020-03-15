package 面试题68_I.二叉搜索树的最近公共祖先;


class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > Math.max(p.val, q.val))
                root = root.left;
            else if (root.val < Math.min(p.val, q.val))
                root = root.right;
            else return root;
        }
    }

}