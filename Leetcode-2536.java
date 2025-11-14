class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        for (int[] q : queries) {
            int r1 = q[0], r2 = q[2], c1 = q[1], c2 = q[3];

            diff[r1][c1] += 1;
            diff[r1][c2 + 1] -= 1;
            diff[r2 + 1][c1] -= 1;
            diff[r2 + 1][c2 + 1] += 1;
        }

        for (int row = 0; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                diff[row][col] += diff[row][col - 1];
            }
        }

        for (int col = 0; col <= n; col++) {
            for (int row = 1; row <= n; row++) {
                diff[row][col] += diff[row - 1][col];
            }
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = diff[i][j];
            }
        }

        return result;
    }
}
