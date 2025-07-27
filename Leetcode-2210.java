class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> filtered = new ArrayList<>();

        filtered.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                filtered.add(nums[i]);
            }
        }

        int count = 0;

        for (int i = 1; i < filtered.size() - 1; i++) {
            int current = filtered.get(i);
            int prev = filtered.get(i - 1);
            int next = filtered.get(i + 1);

            if ((current > prev && current > next) || (current < prev && current < next)) {
                count += 1;
            }
        }

        return count;
    }
}
