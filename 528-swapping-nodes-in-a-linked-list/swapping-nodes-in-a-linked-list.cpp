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
    ListNode* func1(ListNode* head,int tar,int temp)
    {
        if(head==nullptr) return nullptr;
        if(temp==tar)
        {
            return head;
        }
        return func1(head->next,tar,temp+1);
    }
    ListNode* swapNodes(ListNode* head, int k) {
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        int count=0;
        while(head){count++;head=head->next;}
        ListNode* one = func1(dummy,k,0);
        ListNode* two = func1(dummy,count-k+1,0);
        int temp;
        temp=one->val;
        one->val=two->val;
        two->val=temp;
        
        return dummy->next;
    }
};