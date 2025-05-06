class Solution {
    public String convert(String s, int numRows) {
        String arr[] = new String[numRows];
        Arrays.fill(arr,"");
        int n = s.length();

        int i = 0;

        while(i<n)
        {
            for(int j = 0;j<numRows && i<n;j++,i++)
            {
                arr[j]+=s.charAt(i);
            }
            for(int j = numRows-2;j>=1 && i<n;j--,i++)
            {
                arr[j]+=s.charAt(i);
            }
        }

        String ans = "";
        for(String k : arr)
        {
            ans+=k;
        }

        return ans;
        
    }
}