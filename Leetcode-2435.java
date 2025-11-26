class Solution {
    int mod = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][k];
        return dfs(grid, k, 0, 0, grid[0][0] % k, dp);
    }

    private int dfs(int[][] grid, int k, int x, int y, int rem, Integer[][][] dp) {
        int m = grid.length, n = grid[0].length;

        if (x == m - 1 && y == n - 1) {
            return rem == 0 ? 1 : 0;
        }

        if (dp[x][y][rem] != null) {
            return dp[x][y][rem];
        }

        long paths = 0;

        // R
        if (y + 1 < n) {
            int newR = (rem + grid[x][y + 1]) % k;
            paths = dfs(grid, k, x, y + 1, newR, dp);
        }

        // B
        if (x + 1 < m) {
            int newR = (rem + grid[x + 1][y]) % k;
            paths += dfs(grid, k, x + 1, y, newR, dp);
        }

        int result = (int)(paths % mod);
        dp[x][y][rem] = result;

        return dp[x][y][rem];
    }
}
