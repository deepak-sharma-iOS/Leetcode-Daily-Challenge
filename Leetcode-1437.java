class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int steps = 0;

        for (int n : nums) {
            if (n == 0) {
                steps -= 1;
            } else {
                if (steps <= 0) {
                    steps = k;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
