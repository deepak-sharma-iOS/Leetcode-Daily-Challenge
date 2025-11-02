class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] matrix = new char[m][n];

        for (int[] g : guards) {
            int x = g[0], y = g[1];
            matrix[x][y] = 'G';
        }

        for (int[] w : walls) {
            int x = w[0], y = w[1];
            matrix[x][y] = 'W';
        }

        int[][] directions = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
        };

        for (int[] g : guards) {
            int x = g[0], y = g[1];
            
            for (int[] d : directions) {
                dfs(x + d[0], y + d[1], matrix, m, n, d);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    count += 1;
                }
            }
        }

        return count;
    }

    private void dfs(int x, int y, char[][] matrix, int m, int n, int[] dir) {
        if (x < 0 || y < 0 || x >= m || y >= n) { return; }
        if (matrix[x][y] == 'G' || matrix[x][y] == 'W') { return; }

        if (matrix[x][y] == 0) {
            matrix[x][y] = 'V';
        }

        dfs(x + dir[0], y + dir[1], matrix, m, n, dir);
    }
}
