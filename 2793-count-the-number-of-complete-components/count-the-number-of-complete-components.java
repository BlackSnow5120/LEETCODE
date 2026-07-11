class Solution {

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        // Build connected components
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        // Count vertices in each component
        Map<Integer, Integer> nodeCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            nodeCount.put(root, nodeCount.getOrDefault(root, 0) + 1);
        }

        // Count edges in each component
        Map<Integer, Integer> edgeCount = new HashMap<>();

        for (int[] edge : edges) {
            int root = uf.find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }

        int ans = 0;

        for (int root : nodeCount.keySet()) {
            int nodes = nodeCount.get(root);
            int edgesInComponent = edgeCount.getOrDefault(root, 0);

            if (edgesInComponent == nodes * (nodes - 1) / 2) {
                ans++;
            }
        }

        return ans;
    }
}