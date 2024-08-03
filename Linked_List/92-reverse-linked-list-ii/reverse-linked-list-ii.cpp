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
    ListNode* func(ListNode* head,ListNode* prev,ListNode* final) {
        if(head->next == final )
        {
            head->next=prev;
            return head;
        }
        ListNode* a = func(head->next,head,final);
        head->next=prev;
        return a;
    }

    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* temp = head;
        ListNode* temp1 = nullptr;
        ListNode* temp2 = nullptr;
        if(head==nullptr || head->next==nullptr || abs(left-right)==0)
        {
            return head;
        }
        int ptr = 1;
        while(temp)
        {
            if(ptr==left-1 && left>1)
            {
                temp1=temp;
            }
            if(ptr==right+1)
            {
                // cout<<ptr;
                temp2=temp;
            }
            ptr++;
            temp=temp->next;
        }
        if(left==1)
        {
            
            return func(head,temp2,temp2);
        }
        cout<<temp1->val;
        temp1->next = func(temp1->next,temp2,temp2);
        return head;
    }
};