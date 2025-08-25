class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int key = i + j;

                map.computeIfAbsent(key, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        int[] result = new int[rows * columns];
        boolean flip = true;
        int index = 0;

        // 3 * 3 -> 0, 1, 2, 3, 4

        for (int k = 0; k < rows + columns - 1; k++) {
            List<Integer> diagonals = map.get(k);

            if (flip) {
                Collections.reverse(diagonals);
            }

            flip = !flip;

            for (int val : diagonals) {
                result[index] = val;
                index += 1;
            }
        }

        return result;
    }
}
