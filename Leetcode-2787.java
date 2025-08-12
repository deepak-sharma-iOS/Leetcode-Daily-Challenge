class Solution {
    private int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        Integer[][] memo = new Integer[n + 1][n + 1]; 
        return helper(n, 1, x, memo);
    }

    private int calculatePow(int a, int power) {
        long result = 1;

        for (int i = 0; i < power; i++) {
            result = result * a;
        }

        return (int) result;
    }

    private int helper(int remaining, int current, int power, Integer[][] memo) {
        // BC
        if (remaining < 0) {
            return 0;
        }

        if (remaining == 0) {
            return 1;
        }

        int currentPower = calculatePow(current, power);
        if (currentPower > remaining) {
            return 0;
        }

        if (memo[remaining][current] != null) {
            return memo[remaining][current];
        }

        // P
        int pick = helper(remaining - currentPower, current + 1, power, memo) % MOD;

        // NP
        int notPick = helper(remaining, current + 1, power, memo) % MOD;

        memo[remaining][current] = (pick + notPick) % MOD;

        return memo[remaining][current];
    }
}
