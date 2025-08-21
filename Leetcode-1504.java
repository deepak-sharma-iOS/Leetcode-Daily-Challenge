// Optimized
class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int result = 0;

        int[] heights = new int[columns];

        // O(m^2 * n^2)

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                heights[j] = mat[i][j] == 0 ? 0 : heights[j] + 1;
            }

            result += helper(mat, heights);
        }

        return result;  
    }

    private int helper(int[][] mat, int[] heights) {
        int result = 0;
        int rows = mat.length;
        int columns = mat[0].length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] sum = new int[columns];

        for (int j = 0; j < columns; j++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + heights[j] * (j - prev);

            } else {
                sum[j] = heights[j] * (j + 1);
            }

            result += sum[j];

            stack.push(j);

        }

        return result;
    }
}


// Brute 
class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 1) {
                    result += helper(mat, i, j);
                }
            }
        }

        return result;  
    }

    private int helper(int[][] mat, int row, int column) {
        int result = 0;
        int rows = mat.length;
        int columns = mat[0].length;

        int minWidth = columns;
        int width = 0;

        for (int i = row; i < rows; i++) {
            if (mat[i][column] == 0) {
                break;
            }

            width = 0;

            for (int j = column; j < minWidth; j++) {
                if (mat[i][j] == 0) {
                    minWidth = j;
                    break;
                }
                width += 1;
            }

            minWidth = Math.min(minWidth, column + width);
            result += (minWidth - column);
        }

        return result;
    }
}
