class Solution {
    public int minNumberOperations(int[] target) {
        int sum = target[0];

        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                sum += (target[i] - target[i - 1]);
            }
        }

        return sum;
    }
}
