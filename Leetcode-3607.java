class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);

        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        for (int x : dsu.rank) {
            System.out.println(x);
        }

        Map<Integer, HashSet<Integer>> onlineMap = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> heap = new HashMap<>();


        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            onlineMap.putIfAbsent(root, new HashSet<>());
            heap.putIfAbsent(root, new PriorityQueue<>());

            onlineMap.get(root).add(i);
            heap.get(root).add(i);
        }

        List<Integer> result = new ArrayList<>();
        boolean[] offline = new boolean[c + 1];

        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];
            int root = dsu.find(x);

            if (type == 1) {
                if (!offline[x]) {
                    result.add(x);
                } else {
                    PriorityQueue<Integer> pq = heap.get(root);
                    HashSet<Integer> onlineSet = onlineMap.get(root);

                    while (!pq.isEmpty() && offline[pq.peek()]) {
                        pq.poll();
                    }

                    if (pq.isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(pq.peek());
                    }
                }

            } else {
                if (!offline[x]) {
                    offline[x] = true;
                    onlineMap.get(root).remove(x);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
        
    }

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);

            if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else if (rank[pb] > rank[pa]) {
                parent[pa] = pb;
            } else {
                parent[pb] = pa;
                rank[pa] += 1;
            }
        }
    }
}
