class Solution {
    public int magicalSum(int m, int k, int[] nums) {
        long MOD = 1_000_000_007L;
        List<List<Integer>> all = new ArrayList<>();
        generateSequences(m, nums.length, all, new ArrayList<>());

        long total = 0;

        for (List<Integer> seq : all) {
            long sum = 0;
            // 2 ^ 5 => 1 << 5 
            for (int index : seq) {
                sum += (1L << index);
            }

            if (Long.bitCount(sum) == k) {
                long product = 1;
                for (int index : seq) {
                    product = (product * nums[index]) % MOD;
                }

                total = (total + product) % MOD;
            }
        }

        return (int) total;
    }

    private void generateSequences(int m, int n, List<List<Integer>> all, 
    List<Integer> current) {
        if (current.size() == m) {
            all.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < n; i++) {
            current.add(i);
            generateSequences(m, n, all, current);
            current.remove(current.size() - 1);
        }
    }
}
