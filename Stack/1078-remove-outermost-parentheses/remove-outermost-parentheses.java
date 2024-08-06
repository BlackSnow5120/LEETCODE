class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        Stack <Character> stack = new Stack <Character>();
        int add=0;
        for(int i=0;i<s.length();i++)
        {
            char a = s.charAt(i);
            if(a=='(')
            {
                if(add==0){add=1;}
                else
                {
                    add++;
                    ans+=a;
                }
            }
            else
            {
                if(add>1)
                {
                    ans+=a;
                }
                add--;
            }
        }
        return ans;
    }
}