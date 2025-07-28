class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;

        for (int num : nums) {
            maxOr = maxOr | num;
        }

        return helper(nums, 0, maxOr, 0);
    }

    private int helper(int[] nums, int index, int maxOr, int currentOr) {
        // Base Condtion
        if (index >= nums.length) {
            return currentOr == maxOr ? 1 : 0;
        }

        int take = helper(nums, index + 1, maxOr, currentOr | nums[index]);
        int notTake = helper(nums, index + 1, maxOr, currentOr);

        return take + notTake;
    }
}
