class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0, right = 0;
        int n = fruits.length;
        int maxFruits = 0;
        int currentMaxFruits = 0;

        while (right < n) {
            currentMaxFruits += fruits[right][1];

            while (left <= right && !isReachable(fruits[left][0], fruits[right][0], startPos, k)) {
                currentMaxFruits -= fruits[left][1];
                left += 1;
            }

            maxFruits = Math.max(currentMaxFruits, maxFruits);
            right += 1;
        }

        return maxFruits;
    }

    private boolean isReachable(int left, int right, int startPos, int k) {
        int option1 = Math.abs(startPos - left) + right - left;
        int option2 = Math.abs(startPos - right) + right - left;

        return Math.min(option1, option2) <= k;
    }
}
