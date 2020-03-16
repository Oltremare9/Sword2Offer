package 面试题54.二叉搜索树的第k大节点;

import sun.reflect.generics.tree.Tree;

import java.util.*;


class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = -1;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        /*
        //迭代处理
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        int index=0;
        TreeNode node=root;
        TreeNode temp;
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                temp=stack.pop();
                list.add(index++,temp.val);
                System.out.println(temp.val);
                node=temp.right;
            }
        }
        return list.get(list.size()-k);
        */
        count = k;
        midSearch(root);
        return res;
    }

    private void midSearch(TreeNode node) {
        if (node == null)
            return;
        midSearch(node.right);
        count--;
        if (count == 0)
            res = node.val;
        midSearch(node.left);
    }

}