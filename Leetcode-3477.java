class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = 0;
        boolean[] used = new boolean[baskets.length];

        for (int fruit : fruits) {
            boolean isPlaced = false;
            for (int j = 0; j < baskets.length; j++) {
                if (fruit <= baskets[j] && !used[j]) {
                    isPlaced = true;
                    used[j] = true;
                    break;
                }
            }

            if (!isPlaced) {
               unplaced += 1; 
            }
        }

        return unplaced;
    }
}
