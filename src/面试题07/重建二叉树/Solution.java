package 面试题07.重建二叉树;

import java.util.Map;
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
    int index = 0;
    int[] pre;
    int[] mid;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        pre = preorder;
        mid = inorder;
        TreeNode head = new TreeNode(pre[index++]);
        int pos = getNode(head, 0, pre.length);
        head.left = getChild(0, pos);
        head.right = getChild(pos + 1, pre.length);
        return head;
    }

    private TreeNode getChild(int begin, int end) {
        if (begin >= end)
            return null;
        TreeNode node = new TreeNode(pre[index++]);
        int pos = getNode(node, begin, end);
        node.left = getChild(begin, pos);
        node.right = getChild(pos + 1, end);
        return node;
    }

    private int getNode(TreeNode node, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (node.val == mid[i])
                return i;
        }
        return -1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}