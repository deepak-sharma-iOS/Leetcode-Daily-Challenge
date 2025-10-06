class Solution {
    private class Entry {
        int x, y, t;

        Entry(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public int swimInWater(int[][] grid) {
        PriorityQueue<Entry> queue = new PriorityQueue<>((a, b) -> a.t - b.t);
        queue.offer(new Entry(0, 0, grid[0][0]));

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        while (!queue.isEmpty()) {
            Entry entry = queue.poll();
            int x = entry.x;
            int y = entry.y;
            int t = entry.t;

            if (x == n - 1 && y == n - 1) {
                return t;
            }

            visited[x][y] = true;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (isValid(nx, ny, n) && !visited[nx][ny]) {
                    queue.offer(new Entry(nx, ny, Math.max(t, grid[nx][ny])));
                }
            }
        }

        return 0;
    }

    private boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
