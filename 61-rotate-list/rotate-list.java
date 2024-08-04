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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){return head;}
        ListNode temp = head;
        ListNode last = head;
        int size=0;
        while(temp!=null)
        {
            size++;
            last=temp;
            temp=temp.next;
        }
        k=k%size;
        if(k==0){return head;}
        int tempsize=1;
        ListNode start = head;
        while(start!=null && tempsize!=size-k)
        {
            tempsize++;
            start=start.next;
        }
        ListNode newHead = start.next;
        start.next=null;
        last.next=head;
        return newHead;

    }
}