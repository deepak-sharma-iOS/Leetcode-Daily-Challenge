class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] lastSeen = new int[32];
        int[] ans = new int[n];

        // 3
        for (int i = n - 1; i >= 0; i--) {
            for (int bit = 0; bit < 32; bit++) {
                if (((nums[i] >> bit) & 1) == 1) {
                    lastSeen[bit] = i;
                }
            }

            int maxIndex = i;
            for (int bit = 0; bit < 32; bit++) {
                maxIndex = Math.max(maxIndex, lastSeen[bit]);
            }

            ans[i] = maxIndex - i + 1;
        }

        return ans;
    }
}
