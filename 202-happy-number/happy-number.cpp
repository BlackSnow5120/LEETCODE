class Solution {
public:
    bool isHappy(int n) {
        int ans = 0;
        unordered_map <int,int> mp1;
        while(ans!=1 && mp1[ans]!=1)
        {
        mp1[ans]=1;
        ans=0;
        while(n)
        {
            ans+=(n%10)*(n%10);
            n=n/10;
        }
        n=ans;
        }
        return ans==1;
    }
};