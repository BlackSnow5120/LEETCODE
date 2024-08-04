/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    public Node flatten(Node head) {
        Node temp = head;
        Stack<Node> s = new Stack<Node>();
        s.push(head);
        Node prev1 = null;
        while (!s.empty()) {
            head = s.peek();
            s.pop();
            while (head != null) {
                if (head.child != null) {
                    if (head.next != null) {
                        s.push(head.next);
                    }
                    head.next = head.child;
                    head.child = null;
                }
                head.prev = prev1;
                if (prev1 != null) {
                    prev1.next = head;
                }
                prev1 = head;
                head = head.next;
            }
        }
        return temp;
    }
}