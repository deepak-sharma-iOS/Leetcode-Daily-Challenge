class Solution {
    public int maxSumDivThree(int[] nums) {
        Integer[][] dp = new Integer[nums.length][3];
        return helper(nums, 0, 0, dp);
    }

    private int helper(int[] nums, int index, int rem,Integer[][] dp) {
        if (index == nums.length) {
            return rem == 0 ? 0 : -1;
        }

        if (dp[index][rem] != null) {
            return dp[index][rem];
        }

        int pick = helper(nums, index + 1, (rem + nums[index]) % 3, dp);
        if (pick != -1) {
            pick += nums[index];
        }

        int notPick = helper(nums, index + 1, rem, dp);

        int result = Math.max(pick, notPick);
        dp[index][rem] = result;
        return dp[index][rem];
    }
}
