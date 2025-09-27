class Solution {
    // Area=0.5​×∣x1​(y2​−y3​)+x2​(y3​−y1​)+x3​(y1​−y2​)∣
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];

                    double area = 0.5 * Math.abs(
                        p1[0] * (p2[1] - p3[1]) + 
                        p2[0] * (p3[1] - p1[1]) + 
                        p3[0] * (p1[1] - p2[1]) 
                    );

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
