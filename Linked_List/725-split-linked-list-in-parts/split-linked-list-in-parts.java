/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode func(ListNode head, int k) {
        for (int i = 0; i < k - 1; i++) {
            if (head != null) {
                head = head.next;
            }
        }
        if (head != null) {
            ListNode a = head.next;
            head.next = null;
            return a;
        }
        return head;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] a = new ListNode[k];
        ListNode temp = head;
        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int s1 = size / k;
        int left = size % k;
        int count = 0;
        int isleft = 0;
        while (count < k) {
            a[count] = head;
            if (left > 0) {
                isleft = 1;
            }
            head = func(head, s1 + isleft);
            left--;
            isleft = 0;
            count++;
        }

        return a;
    }
}