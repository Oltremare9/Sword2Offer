package 面试题25.合并两个排序的链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode res=head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                head.next=l1;
                l1=l1.next;
                head=head.next;
            }else{
                head.next=l2;
                l2=l2.next;
                head=head.next;
            }
        }
        while(l1!=null){
            head.next=l1;
            l1=l1.next;
            head=head.next;
        }
        while(l2!=null){
            head.next=l2;
            l2=l2.next;
            head=head.next;
        }
        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}