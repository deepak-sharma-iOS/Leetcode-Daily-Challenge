class Solution {
    int count = 1;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        dfs(0, -1, values, k, adj);

        return count;
    }

    private long dfs(int u, int p, int[] values, int k, List<List<Integer>> adj) {
        long sum = values[u];

        for (int v : adj.get(u)) {
            if (v == p) {
                continue;
            }

            long sub = dfs(v, u, values, k, adj);
            if (sub % k == 0) {
                count += 1;
            } else {
                sum += sub;
            }
        }

        return sum;
    }
}
