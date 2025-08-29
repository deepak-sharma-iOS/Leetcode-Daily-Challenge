class Solution {
    private Boolean[][] aliceDP;
    private Boolean[][] bobDP;

    public long flowerGame(int n, int m) {
        return helper(n, m);
        // long count = 0;
        // aliceDP = new Boolean[n + 1][m + 1];
        // bobDP = new Boolean[n + 1][m + 1];

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= m; j++) {
        //         if (aliceTurn(i, j)) {
        //            count += 1; 
        //         }
        //     }
        // }

        // return count;
    }

    private long helper(int n, int m) {
        long evenN = n / 2; // 11 // 12 // 10
        long oddN = (n + 1) / 2; // 11 

        long evenM = m / 2;
        long oddM = (m + 1) / 2;

        return evenN * oddM + oddN * evenM;
    }

    private boolean aliceTurn(int x, int y) {
        if (x == 0 && y == 0) {
            return false;
        }

        if (aliceDP[x][y] != null) {
            return aliceDP[x][y];
        }

        // L1
        if (x > 0 && !bobTurn(x - 1, y)) {
            return aliceDP[x][y] = true;
        }

        // L2
        if (y > 0 && !bobTurn(x, y - 1)) {
            return aliceDP[x][y] = true;
        }

        return aliceDP[x][y] = false;
    }

    private boolean bobTurn(int x, int y) {
        if (x == 0 && y == 0) {
            return false;
        }

        if (bobDP[x][y] != null) {
            return bobDP[x][y];
        }

        // L1
        if (x > 0 && !aliceTurn(x - 1, y)) {
            return bobDP[x][y] = true;
        }

        // L2
        if (y > 0 && !aliceTurn(x, y - 1)) {
            return bobDP[x][y] = true;
        }

        return bobDP[x][y] = false;
    }
}
