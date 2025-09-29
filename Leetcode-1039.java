class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        Integer[][] dp = new Integer[n][n];
        return helper(values, 0, n - 1, dp);
    }

    private int helper(int[] values, int i, int j, Integer[][] dp) {
        if (i + 1 == j) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans, values[i] * values[j] * values[k] + helper(values, i, k, dp) + 
            helper(values, k, j, dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}
