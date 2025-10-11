import java.util.*;

class Solution { 
    private Map<Integer, Integer> freq = new HashMap<>();
    private List<Integer> values;
    private Long[] dp;

    public long maximumTotalDamage(int[] power) {
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }
        values = new ArrayList<>(freq.keySet());
        Collections.sort(values);
        dp = new Long[values.size()];

        return helper(0);        
    } 

    private long helper(int i) {
        if (i >= values.size()) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        long pick = 1L * values.get(i) * freq.get(values.get(i));
        int index = getIndex(values.get(i) + 2);
        pick += helper(index);

        long skip = helper(i + 1);

        long result = Math.max(pick, skip);
        dp[i] = result;
        return dp[i];
    }

    private int getIndex(int target) {
        int l = 0, r = values.size();

        while (l < r) {
            int mid = (l + r) / 2;

            if (values.get(mid) <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
