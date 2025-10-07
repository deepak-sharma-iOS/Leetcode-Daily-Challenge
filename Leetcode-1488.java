class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        List<Integer> dryDays = new ArrayList<>();
        Map<Integer, Integer> filledLakes = new HashMap<>();

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake == 0) {
                dryDays.add(i);
                result[i] = 1;
            } else {
                if (filledLakes.containsKey(lake)) {
                    int lastFilledIndex = filledLakes.get(lake);
                    int index = -1;

                    for (int j = 0; j < dryDays.size(); j++) {
                        if (dryDays.get(j) > lastFilledIndex) {
                            index = dryDays.get(j);
                            dryDays.remove(j);
                            break;
                        }
                    }

                    if (index == -1) {
                        return new int[0];
                    }

                    result[index] = lake;
                }

                filledLakes.put(lake, i);
                result[i] = -1;
            }
        }

        return result;
    }
}
