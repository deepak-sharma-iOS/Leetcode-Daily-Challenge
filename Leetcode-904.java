class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        int maxTrees = 0;

        while (right < fruits.length) {
            freq.put(fruits[right], freq.getOrDefault(fruits[right], 0) + 1);

            while (freq.size() > 2) {
                freq.put(fruits[left], freq.getOrDefault(fruits[left], 0) - 1);
                if (freq.get(fruits[left]) == 0) {
                    freq.remove(fruits[left]);
                }
                left += 1;
            }

            maxTrees = Math.max(maxTrees, right - left + 1);

            right += 1;
        }


        return maxTrees;
    }
}
