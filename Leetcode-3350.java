class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int cl = 1;
        int pl = 0;
        int result = 0;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cl += 1;
            } else {
                pl = cl;
                cl = 1;
            }

            result = Math.max(result, Math.max(cl / 2, Math.min(cl, pl)));
        }

        return result;
    }
}
