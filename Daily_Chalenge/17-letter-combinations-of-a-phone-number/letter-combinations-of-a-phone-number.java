class Solution {
        
    public void func(List<String> ans,String temp, String digits,int start,String[] phn)
    {
        if(start== digits.length())
        {
            ans.add(temp);
            return;
        }
        for(int j=0;j<phn[digits.charAt(start) - '2'].length();j++)
            {
                func(ans,temp + phn[digits.charAt(start) - '2'].charAt(j),digits,start+1,phn);
            }
    }
    public List<String> letterCombinations(String digits) {
        String[] phn = new String[8];
        phn[0] = "abc";
        phn[1] = "def";
        phn[2] = "ghi";
        phn[3] = "jkl";
        phn[4] = "mno";
        phn[5] = "pqrs";
        phn[6] = "tuv";
        phn[7] = "wxyz";
        if(digits.length()==0)
        {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        func(ans,new String(),digits,0,phn);
    
        return ans;
    }
}