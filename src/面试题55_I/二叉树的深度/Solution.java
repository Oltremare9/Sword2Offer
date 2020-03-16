package 面试题55_I.二叉树的深度;

import javafx.util.Pair;

import java.util.Stack;

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

    /*递归做法
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }
    private int getDepth(TreeNode node){
        if(node==null)
            return 0;
        else{
            return 1+Math.max(getDepth(node.left),getDepth(node.right));
        }
    }
    */
    //非递归
    public int maxDepth(TreeNode root) {
        int res = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node = (TreeNode) pair.getKey();
            if (node == null)
                continue;
            res = Math.max(res, (Integer) pair.getValue());
            stack.push(new Pair<>(node.left, (Integer) pair.getValue() + 1));
            stack.push(new Pair<>(node.right, (Integer) pair.getValue() + 1));
        }
        return res;
    }
}