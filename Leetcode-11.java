class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = 0;

        int lp = 0;
        int rp = n - 1;

        while (lp < rp) {
            int width = rp - lp;
            int minHeight = Math.min(height[rp], height[lp]);
            int water = minHeight * width;
            maxWater = Math.max(maxWater, water);

            if (height[lp] < height[rp]) {
                lp += 1;
            } else {
                rp -= 1;
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int width = j - i;
        //         int minHeight = Math.min(height[j], height[i]);
        //         int water = minHeight * width;
        //         maxWater = Math.max(maxWater, water);
        //     }
        // }

        return maxWater;
    }
}
