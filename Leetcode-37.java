class Solution {
    public void solveSudoku(char[][] board) {
        helper(0, 0, board);
    }

    private boolean helper(int r, int c, char[][] board) {
        if (r == 9) {
            return true;
        }

        int nr = r;
        int nc = c;

        if (c == 8) {
            nr += 1;
            nc = 0;
        } else {
            nc += 1;
        }

        if (board[r][c] != '.') {
            return helper(nr, nc, board);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(r, c, board, num)) {
                board[r][c] = num;
                if (helper(nr, nc, board)) {
                    return true;
                }
                board[r][c] = '.';
            }
        }

        return false;
    }

    private boolean isValid(int r, int c, char[][] board, char num) {
        // Row
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) {
                return false;
            }
        }

        // Column
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == num) {
                return false;
            }
        }

        // Grid
        // 9 * 9 - 0, 1, 2 - > 0 ,1 ,2 , 4/ 3= 1 
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
