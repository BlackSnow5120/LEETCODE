class Solution {
    List<List<int[]>> adj = new ArrayList<>();
    boolean[] visited;
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]});
        }

        visited = new boolean[n + 1];

        dfs(1);

        return ans;
    }

    private void dfs(int node) {
        visited[node] = true;

        for (int[] edge : adj.get(node)) {
            ans = Math.min(ans, edge[1]);

            if (!visited[edge[0]]) {
                dfs(edge[0]);
            }
        }
    }
}