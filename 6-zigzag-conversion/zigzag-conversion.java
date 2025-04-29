class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int len = s.length();
        int gap = (numRows*2) - 2;
        int tempgap= numRows - 2;
        int ind2 = 0;
        String ans = "";
        for(int i = 0;i<numRows;i++)
        {
            int ind = i;
            while(ind-i-ind2<len)
            {
                if(ind2!=0 && ind2<tempgap+1)
                {
                    if(ind-i-ind2>0 && ind-i-ind2<len)
                    {
                        ans+=s.charAt(ind-i-ind2);
                    }
                }
                if(ind<len) ans+=s.charAt(ind);
                ind+=gap;
            }
            ind2++;
        }
        return ans;
        
    }
}