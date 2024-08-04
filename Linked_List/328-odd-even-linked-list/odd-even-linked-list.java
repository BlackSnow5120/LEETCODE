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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next==null || head.next.next == null){return head;}
        ListNode dummy = new ListNode(0,head);
        ListNode last = null;
        ListNode temp = head;
        int count=1;
        while(temp!=null)
        {
            if(count % 2 != 0)
            {
                last = temp;
            }
            count++;
            temp=temp.next;
        }
        ListNode ins = last;
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr != null && prev != last)
        {
            prev.next=curr.next;
            curr.next = ins.next;
            ins.next = curr;
            ins=curr;
            prev=prev.next;
            curr=prev.next;
        }
        return dummy.next;
    }
}