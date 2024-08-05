class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1 = new Stack<Character>();
        for(int i = 0;i < s.length();i++)
        {
            char a = s.charAt(i);
            if(a=='(' || a=='{' || a=='[')
            {
                s1.push(a);
            }
            else
            {
                if(s1.empty()){return false;}
                if(a==')'){if(s1.peek()!='('){return false;}else{s1.pop();}}
                if(a==']'){if(s1.peek()!='['){return false;}else{s1.pop();}}
                if(a=='}'){if(s1.peek()!='{'){return false;}else{s1.pop();}}
            }
        }
        if(!s1.empty()){return false;}
        return true;
    }
}