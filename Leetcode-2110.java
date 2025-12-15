class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 1;
        long streak = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                streak += 1;
            } else {
                streak = 1;
            }

            ans += streak;
        }

        return ans;
    }
}
