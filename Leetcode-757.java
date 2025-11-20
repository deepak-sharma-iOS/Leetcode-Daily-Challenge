class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        int p1 = -1, p2 = -1, result = 0;

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];

            boolean hasP1 = p1 >= start && p1 <= end;
            boolean hasP2 = p2 >= start && p2 <= end;

            if (hasP1 && hasP2) {
                continue;
            } else if (hasP2) {
                p1 = p2;
                p2 = end;
                result += 1;
            } else {
                p1 = end - 1;
                p2 = end;
                result += 2; 
            }
        }

        return result;
    }
}
