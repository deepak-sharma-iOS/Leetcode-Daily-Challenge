class Solution {
    public long minOperations(int[][] queries) {
        long result = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1], sum = 0, operation = 0;

            for (long range = 1; range <= r; range *= 4) {
                long sr = Math.max(range, l);
                long er = Math.min(r, range * 4 - 1);

                sum += Math.max(0L, ++operation * (er - sr + 1));
            }

            // 8, 9
            result += (sum + 1) / 2;
        }

        return result;
    }
}
