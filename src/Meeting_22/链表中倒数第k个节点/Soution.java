package Meeting_22.链表中倒数第k个节点;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode quick=head;
        ListNode slow=head;
        while(quick!=null && k-->0){
            quick=quick.next;
        }
        while(quick!=null){
            quick=quick.next;
            slow=slow.next;
        }
        return slow;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}