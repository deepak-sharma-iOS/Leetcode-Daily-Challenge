class Solution {
    public int[][] sortMatrix(int[][] grid) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int key = i - j;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> values = entry.getValue();

            if (key < 0) {
                Collections.sort(values); // inc
            } else {
                values.sort(Collections.reverseOrder()); // dec
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int key = i - j;
                grid[i][j] = map.get(key).remove(0);
            }
        }

        return grid;
    }
}
