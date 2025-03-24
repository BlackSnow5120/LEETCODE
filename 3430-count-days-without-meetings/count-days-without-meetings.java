class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,new Comparator<int[]>(){
            public int compare(int[]a,int[]b)
            {
                return Integer.compare(a[0],b[0]);
            }
        });
        int ans=days;
        int prev=0;
        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            if (start > prev) { 
                ans -= (end - start + 1);
            } else if (end > prev) { 
                ans -= (end - prev);
            }

            prev = Math.max(prev, end); 
        }

        return ans;
    }
}