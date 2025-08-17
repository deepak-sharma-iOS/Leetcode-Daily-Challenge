class Solution {
    public double new21Game(int n, int k, int maxPts) {
        Double[] dp = new Double[n + maxPts + 1];

        return helper(0, n, k, maxPts, dp);
    }

    private double helper(int score, int n, int k, int maxPts, Double[] dp) {
        if (score >= k) {
            return score <= n ? 1.0 : 0.0;
        }

        if (dp[score] != null) {
            return dp[score];
        }

        double prob = 0.0;
        for (int i = 1; i <= maxPts; i++) {
            prob += helper(score + i, n, k, maxPts, dp);
        }

        dp[score] = prob / maxPts;
        
        return dp[score];
    }
}
