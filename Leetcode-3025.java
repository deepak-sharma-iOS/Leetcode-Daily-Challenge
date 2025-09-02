class Solution {
    public int numberOfPairs(int[][] points) {
        return usingOptimizedWay(points);
        // int n = points.length;
        // int ans = 0;

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == j) {
        //             continue;
        //         }

        //         int x1 = points[i][0];
        //         int y1 = points[i][1];
        //         int x2 = points[j][0];
        //         int y2 = points[j][1];

        //         if (x1 <= x2 && y1 >= y2) {
        //             if (isValid(points, i, j)) {
        //                 ans += 1;
        //             }
        //         }
        //     }
        // }

        // return ans;
    }
    
    // && y1 >= y2

    private int usingOptimizedWay(int[][] points) {
        int n = points.length;
        int ans = 0;
        
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < n; i++) {
            int y1 = points[i][1];
            int k = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int y2 = points[j][1];

                if (y2 > y1) {
                    continue;
                }

                if (y2 > k) {
                    ans += 1;
                    k = y2;
                }
            }
        }

        return ans;
    }

/// 2, 4, 2, 4
    private boolean isValid(int[][] points, int i, int j) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];

        for (int p = 0; p < points.length; p++) {
            if (p == i || p == j) {
                continue;
            }

            int x = points[p][0];
            int y = points[p][1];

            if (x <= x2 && x >= x1 && y <= y1 && y >= y2) {
                return false;
            }
        }

        return true;
    }
}
