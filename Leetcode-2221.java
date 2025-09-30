class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int len = n; len > 1; len--) {
            for (int i = 0; i < len - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }

        return nums[0];
    }
}
