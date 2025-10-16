class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums) {
            int rem = (n % value + value) % value;
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }

        int smallest = Integer.MAX_VALUE;
        int remainder = 0;
        
        for (int i = 0; i < value; i++) {
            int count = freq.getOrDefault(i, 0);
            if (count < smallest) {
                smallest = count;
                remainder = i;
            }
        }

        return smallest * value + remainder;
    }
}
