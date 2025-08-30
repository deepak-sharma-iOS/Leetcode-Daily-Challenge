class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];

                if (ch == '.') {continue;}

                String row = "ROW_" + r + "_" + ch;
                String column = "COLUMN_" + c + "_" + ch;
                String grid = "GRID_" + r/3 + "_" + c/3 + "_" + ch;

                if (set.contains(row) || set.contains(column) || set.contains(grid)) {
                    return false;
                }

                set.add(row);
                set.add(column);
                set.add(grid);
            }
        }


        // // Row
        // for (int r = 0; r < 9; r++) {
        //     Set<Character> set = new HashSet<>();
        //     for (int c = 0; c < 9; c++) {
        //         char ch = board[r][c];

        //         if (ch == '.') {
        //             continue;
        //         }

        //         if (set.contains(ch)) {
        //             return false;
        //         }

        //         set.add(ch);
        //     }
        // }

        // // Column
        // for (int c = 0; c < 9; c++) {
        //     Set<Character> set = new HashSet<>();
        //     for (int r = 0; r < 9; r++) {
        //         char ch = board[r][c];

        //         if (ch == '.') {
        //             continue;
        //         }

        //         if (set.contains(ch)) {
        //             return false;
        //         }

        //         set.add(ch);
        //     }
        // }

        // // Grid
        // for (int sr = 0; sr < 9; sr += 3) {
        //     int er = sr + 2;

        //     for (int sc = 0; sc < 9; sc += 3) {
        //         int ec = sc + 2;
                
        //         Set<Character> set = new HashSet<>();
        //         for (int i = sr; i <= er; i++) {
        //             for (int j = sc; j <= ec; j++) {
        //                 char ch = board[i][j];

        //                 if (ch == '.') { continue; }

        //                 if (set.contains(ch)) {
        //                     return false;
        //                 }

        //                 set.add(ch);
        //             }
        //         }
        //     }
        // }

        return true;
    }
}
