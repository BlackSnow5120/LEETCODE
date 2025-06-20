class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;

        int low=Integer.MAX_VALUE;

        for(int i = 0; i<prices.length;i++)
        {
            if(prices[i]<low) low = prices[i];

            if(prices[i] - low > ans) ans = prices[i] - low;
        }
        return ans;
    }
}