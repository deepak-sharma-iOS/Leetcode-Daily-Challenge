class Solution {
    public int specialTriplets(int[] nums) {
        long mod = 1000000007;
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();

        for (int n : nums) {
            right.put(n, right.getOrDefault(n, 0) + 1);
        }

        long result = 0;
        for (int j = 0; j < nums.length; j++) {
            int value = nums[j];

            right.put(value, right.getOrDefault(value, 0) - 1);

            int target = 2 * value;

            long leftCount = left.getOrDefault(target, 0);
            long rightCount = right.getOrDefault(target, 0);

            result = (result + (leftCount * rightCount) % mod) % mod;

            left.put(value, left.getOrDefault(value, 0) + 1);
        }

        return (int) result;
    }
}
