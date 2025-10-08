class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int s = spells[i];

            int left = 0, right = m - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                long product = (long) potions[mid] * s;

                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            
            }
            result[i] = m - left;
        }

        return result;
    }
}
