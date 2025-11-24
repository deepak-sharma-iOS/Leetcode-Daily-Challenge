class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int decimal = 0;

        for (int n : nums) {
            decimal = (2 * decimal + n) % 5;
            res.add(decimal % 5 == 0);
        }

        return res;
    }
}
