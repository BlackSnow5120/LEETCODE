class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> m1 = new HashMap<>();
        int ans=0;
        int startind=0;
        for(int i=0;i<s.length();i++)
        {
            int temp = m1.getOrDefault(s.charAt(i),-1);
            if(temp >= startind)
            {
                ans = Integer.max(ans,i-startind);
                startind=temp+1;
            }
            m1.put(s.charAt(i),i);
        }
        ans = Integer.max(ans,s.length()-startind);
        return ans;
    }
}