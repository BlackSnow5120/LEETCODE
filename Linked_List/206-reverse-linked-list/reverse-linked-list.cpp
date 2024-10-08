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
    ListNode* func(ListNode* head,ListNode* prev)
    {
        if(head == nullptr)
        {
            return prev;
        }
        ListNode* a = func(head->next,head);
        head->next=prev;
        return a;
        
    }
    ListNode* reverseList(ListNode* head) {
        return func(head,nullptr);
    }
};