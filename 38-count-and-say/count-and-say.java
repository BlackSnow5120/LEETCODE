class Solution {
    public String func1(String s)
    {
        int len = s.length();
        int i = 0;
        String ans="";
        Integer count = 0;
        char temp = s.charAt(0);
        while(i<len)
        {
            if(s.charAt(i)!=temp)
            {
                ans+=count.toString();
                ans+=temp;
                temp=s.charAt(i);
                count=0;
            }
            count++;
            i++;
        }
        ans+=count.toString();
        ans+=s.charAt(len-1);
        return ans;
    }
    public String countAndSay(int n) {
        String a = "1";

        for(int i =0;i<n-1;i++)
        {
            a = func1(a);
        }
        return a;
    }
}