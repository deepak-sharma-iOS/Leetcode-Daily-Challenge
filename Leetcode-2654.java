class Solution {
    public int minOperations(int[] nums) {
        int overallGCD = nums[0];
        int n = nums.length;

        for (int num : nums) {
            overallGCD = gcd(overallGCD, num);
        }

        if (overallGCD > 1) {
            return -1;
        }

        int ones = 0;
        for (int num : nums) {
            if (num == 1) {
                ones += 1;
            }
        }

        if (ones > 0) {
            return n - ones;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    min = Math.min(min, j - i);
                    break;
                }
            }
        }

        return min + n - 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
