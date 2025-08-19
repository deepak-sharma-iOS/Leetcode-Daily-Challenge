class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long count = 0;

        for (int num : nums) {
            if (num == 0) {
                count += 1;
                result += count;
            } else {
                count = 0;
            }
        }

        return result;
    }
}
