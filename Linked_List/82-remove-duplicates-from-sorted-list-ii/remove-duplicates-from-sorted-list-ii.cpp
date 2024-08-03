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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* temp=head;
        ListNode* temp2=nullptr;
        vector<int> vec(201,0);
        if(temp==nullptr || temp->next==nullptr){return head;}
        int flag=0;
        while(temp->next!=nullptr)
        {
            if(temp->val == temp->next->val)
            {
                vec[temp->val + 100] = 1;
            }
            temp=temp->next;
        }
        temp=head;
        // cout<<vec[102];
        while(temp!=nullptr)
        {
            if(flag ==0)
            {
            if(vec[temp->val + 100] == 0)
            {
                head=temp;
                temp2=head;
                flag=1;
            }
            }
            else
            {
                if(vec[temp->val + 100] == 0)
            {
                temp2->next=temp;
                temp2=temp;
            }
            }
            temp=temp->next;
        }
        if(flag==0)
        {
            head=nullptr;
        }
        if(temp2!=nullptr)
        {
            temp2->next=nullptr;
        }
        return head;
    }
};