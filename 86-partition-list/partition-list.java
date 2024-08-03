/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode start = dummy;
        while(curr!= null)
        {
            if(curr.val < x)
            {
                prev.next = curr.next;
                curr.next = start.next;
                start.next = curr;
                start = curr;
            }
            prev=curr;
            curr=curr.next;
        }

        return dummy.next;

    }
}