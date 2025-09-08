class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;

            if (!isContainsZero(a) && !isContainsZero(b)) {
                return new int[]{a, b};
            }
        }

        return new int[2];
    }

    private boolean isContainsZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return true;
            }
            n = n / 10;
        }

        return false;
    }
}
