class Solution {
    public int numSub(String s) {
        long mod = 1000000007, ones = 0, result = 0;

        // 11101111

        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones += 1;
            } else {
                long sum = (ones * (ones + 1) / 2) % mod;
                result = (result + sum) % mod;
                ones = 0;
            }
        }

        long sum = (ones * (ones + 1) / 2) % mod;
        result = (result + sum) % mod;

        return (int) result;
    }
}
