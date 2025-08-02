class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int fruit : basket1) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
        }

        for (int fruit : basket2) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) - 1);
        }

        List<Integer> excessA = new ArrayList<>();
        List<Integer> excessB = new ArrayList<>();
        int minFruit = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int fruit = entry.getKey();
            int diff = entry.getValue();

            if (diff % 2 != 0) {
                return -1;
            }

            minFruit = Math.min(minFruit, fruit);

            int count = Math.abs(diff) / 2;

            for (int i = 0; i < count; i++) {
                if (diff > 0) {
                    excessA.add(fruit);
                } else {
                    excessB.add(fruit);
                }
            }
        }

        Collections.sort(excessA);
        Collections.sort(excessB, Collections.reverseOrder());

        long cost = 0;

        for (int i = 0; i < excessA.size(); i++) {
            int a = excessA.get(i);
            int b = excessB.get(i);
            cost += Math.min(Math.min(a, b), 2 * minFruit);
        }

        return cost;
    }
}
