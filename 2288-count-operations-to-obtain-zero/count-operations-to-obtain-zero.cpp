class Solution {
public:
    int countOperations(int num1, int num2) {
        int ans = 0;
        int a = num1;
        int b = num2;
        while(a!=0 && b!=0){
            ans++;
            if(a>b){
                a=a-b;
            }else{
                b=b-a;
            }
        }
        return ans;
    }
};