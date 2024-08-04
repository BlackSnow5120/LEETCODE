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
    public ListNode reverse(ListNode head,ListNode prev)
    {
        if(head==null)
        {
            return prev;
        }
        ListNode a = reverse(head.next,head);
        head.next=prev;
        return a;
    }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode prev=head;

        ListNode fast=head.next;
        while(fast!= null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode insL1 = slow.next;
        slow.next=null;
        ListNode insL = reverse(insL1,null);
        ListNode temp2 = insL;
        ListNode temp = head;
        while(temp2!=null)
        {
            temp2=insL.next;
            insL.next=temp.next;
            temp.next=insL;
            temp = temp.next.next;
            insL=temp2;
        }
    }
}