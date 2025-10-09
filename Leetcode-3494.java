import java.util.Arrays;

public class Solution {
    public long minTime(int[] skill, int[] mana) {
        int[] users = skill;
        int[] products = mana;

        int m = products.length;
        int n = users.length;

        long[] times = new long[n];

       for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long t = (long) products[i] * users[j];

                if (j == 0) {
                    times[0] = times[0] + t;
                } else {
                    times[j] = Math.max(times[j], times[j - 1]) + t;
                }
            }

            for (int j = n - 2; j >= 0; j--) {
                times[j] = times[j + 1] - (long) products[i] * users[j + 1]; 
            }
       }

       return times[n - 1];

    }
}
