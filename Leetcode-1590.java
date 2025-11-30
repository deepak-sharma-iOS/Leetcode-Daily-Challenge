class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int n : nums) {
            total += n;
        }

        long rem = total % p;
        if (rem == 0) {
            return 0;
        }

        long prefix = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;

            long target = (prefix - rem + p) % p;
            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }

            map.put(prefix, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}
