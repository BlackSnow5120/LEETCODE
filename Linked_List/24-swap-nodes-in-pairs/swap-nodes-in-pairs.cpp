/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode* dummy = new ListNode(0);
        ListNode* temp = head;
        ListNode* prev = dummy;
        ListNode* temp2 = nullptr;



        dummy->next=head;
        int count = 2;
        int tcount=1;
        while(head)
        {
            if(tcount==count)
            {
                prev->next=head;
                temp2->next=head->next;
                head->next=temp2;
                head=temp2;
                prev=temp2;
                tcount=0;
            }
            temp2=head;
            tcount++;
            head=head->next;
        }
        return dummy->next;
    }
};