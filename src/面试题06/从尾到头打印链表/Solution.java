package 面试题06.从尾到头打印链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*递归
    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        getFromNode(head,list);
        int nums[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        return nums;
    }
    private void getFromNode(ListNode node,List res){
        if(node!=null) {
            getFromNode(node.next, res);
            res.add(node.val);
        }
    }
     */
    //栈结构
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int nums[] = new int[stack.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = stack.pop();
        }
        return nums;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}