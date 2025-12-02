class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD = 1000000007;
        Map<Integer, Integer> countByY = new HashMap<>();

        for (int[] p : points) {
            countByY.put(p[1], countByY.getOrDefault(p[1], 0) + 1);
        }

        List<Integer> yCord = new ArrayList<>(countByY.keySet());
        Collections.sort(yCord);

        List<Long> hPlanes = new ArrayList<>();
        for (int y : yCord) {
            long c = countByY.get(y);

            if (c >= 2) {
                hPlanes.add(c * (c - 1) / 2);
            } else {
                hPlanes.add(0L);
            }
        }

        long prefix = 0;
        long result = 0;

        for (Long h : hPlanes) {
            result = (result + prefix * (h % MOD)) % MOD;
            prefix = (prefix + h) % MOD;
        }

        return (int) result;
    }
}
