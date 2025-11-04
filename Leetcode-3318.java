class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int num = nums[i];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ans[0] = calculateSum(freq, x);

        for (int i = k; i < n; i++) {
            int newElement = nums[i];
            int oldElement = nums[i - k];

            freq.put(newElement, freq.getOrDefault(newElement, 0) + 1);
            freq.put(oldElement, freq.getOrDefault(oldElement, 0) - 1);

            if (freq.getOrDefault(oldElement, 0) == 0) {
                freq.remove(oldElement);
            }

            ans[i - k + 1] = calculateSum(freq, x);
        }

        return ans;
    }

    private int calculateSum(Map<Integer, Integer> freq, int x) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());

        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return b.getKey() - a.getKey();
        });

        int sum = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> e : list) {
            if (count >= x) {
                break;
            }
            sum += e.getKey() * e.getValue();

            count += 1;
        }

        return sum;
    }
}
