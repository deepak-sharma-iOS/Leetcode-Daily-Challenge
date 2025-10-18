class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int current = Integer.MIN_VALUE;

        for (int n : nums) {
            int low = n - k;
            int high = n + k;

            if (current + 1 <= high) {
                int assinged = Math.max(current + 1, low);
                current = assinged;
                count += 1;
            }
        }

        return count;
    }
}
