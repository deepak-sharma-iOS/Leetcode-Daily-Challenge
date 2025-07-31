class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        // 1, 2, 4, 8

        for (int num : arr) {
            Set<Integer> current = new HashSet<>();
            current.add(num);

            for (int prevVal : prev) {
                current.add(num | prevVal);
            }


            prev = current;
            result.addAll(current);
        }

        return result.size();
    }
}
