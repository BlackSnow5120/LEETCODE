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
    int func(ListNode* head,int count,int n)
    {
        if(head==nullptr)
        {
            return count;
        }
        int s = func(head->next,count+1,n);
        // cout<<s;
        if(s - n - 1 == count)
        {
            cout<<head->val;
            head->next=head->next->next;
            
        }
        return s;


    }
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy=new ListNode(0);
        dummy->next=head;
        func(dummy,0,n);
        return dummy->next;
    }
};