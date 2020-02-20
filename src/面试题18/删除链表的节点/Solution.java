package 面试题18.删除链表的节点;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * @Description:
     * @Param: [head, val]
     * @return: 面试题18.删除链表的节点.Solution.ListNode
     * @Author: whn
     * @Date: 2020/2/20
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while (quick != null) {
            if (quick.val == val) {
                slow.next = quick.next;
                return head;
            } else {
                slow = quick;
                quick = quick.next;
            }
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}