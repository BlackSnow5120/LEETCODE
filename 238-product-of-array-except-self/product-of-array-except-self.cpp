class Solution {
public:
    vector<int> productExceptSelf(vector<int>& vec) {
        int mul=1;
        int flag=0;
        int count=0;
        for(auto i : vec)
        {
            if(i!=0) mul*=i;
            else count++;
        }
        for(int i=0;i<vec.size();i++)
        {
            if(count > 1)
            {
                vec[i]=0;
            }
            else
            {
                if(count==1)
                {
                if(vec[i]==0)
                {
                    vec[i]=mul;
                }
                else
                {
                    vec[i]=0;
                }
                }
                else
                {
                    vec[i]=mul/vec[i];
                }
            }
        }
        cout<<count;
        return vec;
    }
};