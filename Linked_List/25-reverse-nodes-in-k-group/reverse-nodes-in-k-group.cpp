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
    ListNode* func1(ListNode* head,ListNode* prev,ListNode* final) {
        if(head->next == final )
        {
            head->next=prev;
            return head;
        }
        ListNode* a = func1(head->next,head,final);
        head->next=prev;
        return a;
    }

    void func(ListNode* head,ListNode* prev,int k,int temp) {
        if(head==nullptr)
        {
            if(temp==k+1)
            {
                prev->next = func1(prev->next,nullptr,nullptr);
            }
            return;
        }
        if(temp==k+1)
        {

            ListNode* a = prev->next;
            prev->next = func1(prev->next,head,head);
            func(head,a,k,1);
        }
        else
        {
            // cout<<head->val<<" "<<temp<<endl;
            func(head->next,prev,k,temp+1);
        }

    }
    ListNode* reverseKGroup(ListNode* head, int k) {    
        ListNode* dummy = new ListNode(0);
        dummy->next=head;
        func(head,dummy,k,1);
        return dummy->next;
    }
};