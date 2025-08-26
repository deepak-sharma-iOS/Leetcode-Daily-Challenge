class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double maxDiagonal = 0;

        for (int[] rect : dimensions) {
            int l = rect[0];
            int w = rect[1];

            double d = Math.sqrt(l * l + w * w);
            int area = l * w;

            if (d > maxDiagonal) {
                maxDiagonal = d;
                maxArea = area;
            } else if (d == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
