class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }

        int maxLen = 0;
        int currLen = 0;

        for (int num : nums) {
            if (num == maxVal) {
                currLen += 1;
                maxLen = Math.max(currLen, maxLen);
            } else {
                currLen = 0;
            }
        }

        return maxLen;
    }
}
