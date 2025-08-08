class Solution {
    int[][] operations = {
        {100, 0},
        {75, 25},
        {50, 50},
        {25, 75}
    };

    public double soupServings(int n) {
        if (n > 5000) {
            return 1.0;
        }

        Double[][] memo = new Double[n + 1][n + 1];
        return solve(n, n, memo);
    }

    private double solve(int a, int b, Double[][] memo) {
        // A & B
        if (a <= 0 && b <= 0) {
            return 0.5;
        }

        // A
        if (a <= 0) {
            return 1.0;
        }

        // B
        if (b <= 0) {
            return 0.0;
        }

        if (memo[a][b] != null) {
            return memo[a][b];
        }

        double prob = 0.0;
        for (int[] operation : operations) {
            int leftA = a - operation[0];
            int leftB = b - operation[1];

            prob += solve(leftA, leftB, memo);
        }
        memo[a][b] = 0.25 * prob;
        return memo[a][b];
    }
}
