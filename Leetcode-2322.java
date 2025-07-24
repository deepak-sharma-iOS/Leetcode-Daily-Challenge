class Solution {
    int globalMinScore = Integer.MAX_VALUE;
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // 0 - 1

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int[] pXors = nums.clone();
        calculateXors(0, -1, adj, pXors);
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        // v - u

        int ans = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int u : adj[v]) {
                if (!visited[u]) {
                    visited[u] = true;
                    queue.offer(u);

                    int firstXor = pXors[u];
                    int remainingXor = pXors[0] ^ firstXor;

                    calculate(v, u, nums, firstXor, remainingXor, adj);

                    ans = Math.min(ans, globalMinScore);
                }
            }
        } 

        return ans;
    }
// 4 -> 
    private int calculate(int v, int parent, int[] nums, int firstXor, int remainingXor, List<Integer>[] adj) {
        int currentXor = nums[v];

        for (int child : adj[v]) {
            if (child != parent) {
                int childXor = calculate(child, v, nums, firstXor, remainingXor, adj);

                currentXor = currentXor ^ childXor;

                int secondXor = childXor;
                int thirdXor = remainingXor ^ secondXor;

                int max = Math.max(firstXor, Math.max(secondXor, thirdXor));
                int min = Math.min(firstXor, Math.min(secondXor, thirdXor));

                globalMinScore = Math.min(globalMinScore, max - min);
            }
        }

        return currentXor;
    }

    private void calculateXors(int node, int parent, List<Integer>[] adj, int[] pXors) {
        for (int child : adj[node]) {
            if (child != parent) {
                calculateXors(child, node, adj, pXors);
                pXors[node] = pXors[child] ^ pXors[node];
            }
        }
    }
}
