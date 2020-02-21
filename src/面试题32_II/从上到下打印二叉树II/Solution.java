package 面试题32_II.从上到下打印二叉树II;

import java.util.*;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Object> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        int depth = 0;
        queue.add(root);
        queue.add(depth);
        while (queue.size() != 0) {
            TreeNode node = (TreeNode) queue.poll();
            int dep = (int) queue.poll();
            if (dep >= res.size() || res.get(dep) == null) {
                List<Integer> list = new ArrayList();
                list.add(0, node.val);
                res.add(dep, list);
            } else {
                List<Integer> list = res.get(dep);
                res.remove(dep);
                list.add(list.size(), node.val);
                res.add(dep, list);
            }
            if (node.left != null) {
                queue.add(node.left);
                queue.add(dep + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                queue.add(dep + 1);
            }
        }
        return res;
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