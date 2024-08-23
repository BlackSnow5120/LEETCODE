class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int a=0;
        int b =0;
        int c=n-1;
        int d = n-1;  
        int total = n*n;
        int count=1;

        while(count<=total)
        {
            for(int i=b;i<=d && count<=total;i++)
            {
                ans[a][i]=count++;
            }
            a++;
            for(int i=a;i<=c && count<=total;i++)
            {
                ans[i][d]=count++;
            }
            d--;
            for(int i=d;i>=b && count<=total;i--)
            {
                ans[c][i]=count++;
            }
            c--;
            for(int i=c;i>=a && count<=total;i--)
            {
                ans[i][b]=count++;
            }
            b++;
        }
        return ans;
    }
}