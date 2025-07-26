class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long ans = 0;

        // 5, [1, 2, 3]
        // 6 , [4, 5]

        List<Integer>[] right = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            right[i] = new ArrayList<>();
        }

        // 5 , 2, 3, 4

        for (int[] pair : conflictingPairs) {
            right[Math.max(pair[0], pair[1])].add(Math.min(pair[0], pair[1]));
        }

        long[] left = {0, 0};
        long[] bonus = new long[n + 1];

        for (int r = 1; r <= n; r++) {
            for (int leftValue : right[r]) {
                if (leftValue > left[0]) {
                    left[1] = left[0];
                    left[0] = leftValue;
                } else if (leftValue > left[1]) {
                    left[1] = leftValue;
                }
            }

            ans += r - left[0];

            if (left[0] > 0) {
                bonus[(int)left[0]] += left[0] - left[1];
            }
        }

        long maxBonus = 0;
        for (long b : bonus) {
            maxBonus = Math.max(maxBonus, b);
        }

        return ans + maxBonus;
        
    }

}
