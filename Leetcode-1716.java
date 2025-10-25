// Optimized Approach
class Solution {
    public int totalMoney(int n) {
        int fullWeeks = n / 7;
        int remaining = n % 7;

        int sum = (fullWeeks * (2 * 28 + (fullWeeks - 1) * 7)) / 2; 
        sum += (remaining * (2 * (fullWeeks + 1) + (remaining - 1) * 1)) / 2;

        return sum;
    }
}

// Simple Formula Based
class Solution {
    public int totalMoney(int n) {
        int a = 1;
        int d = 1;

        int sum = 0;

        while (n > 0) {
            int days = Math.min(n, 7);

            sum += ((days * (2 * a + (days - 1) * d)) / 2);
            a += 1;
            n = n - 7;
        }

        return sum;
    }
}
