class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] vis = new int[len]; // To track visited cities
        int ans = 0;
        Queue<Integer> q1 = new LinkedList<>();
        
        for (int i = 0; i < len; i++) {
            if (vis[i] == 0) { // If the city is not visited, it's a new province
                ans++;
                q1.add(i);  // Start BFS from city i
                vis[i] = 1; // Mark city i as visited
                
                while (!q1.isEmpty()) {
                    int s = q1.poll();
                    for (int j = 0; j < len; j++) {
                        if (isConnected[s][j] == 1 && vis[j] == 0) {
                            vis[j] = 1;  
                            q1.add(j);  
                        }
                    }
                }
            }
        }
        return ans; 

    }
}