class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1; // dp[3]

        for (int day = 1; day <= n; day++) {
            long people = dp[day];

            if (people == 0) {
                continue;
            }

            // 6, 6, 4 -> 10
            int start = day + delay;
            int end = day + forget - 1;

            for (int i = start; i <= end && i <= n; i++) {
                dp[i] = (dp[i] + people) % mod;
            }
        }

        /// 
        // n - 10, f = 4
        // 6 - 10
        // 7 - 11, 8 - 12

        // n = 1, f = 4
        // 1 - 4 + 1 = -2

        long result = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                result = (result + dp[day]) % mod;
            }
        }

        return (int) result;

    }
}
