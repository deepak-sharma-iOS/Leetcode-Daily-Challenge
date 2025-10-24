import java.util.*;

class Solution {
    public int nextBeautifulNumber(int n) {
        while (true) {
            n = n + 1;
            if (isBeautiful(n)) {
                return n;
            }
        }
    }

    private boolean isBeautiful(int n) {
        Map<Integer, Integer> freq = new HashMap<>();

        int temp = n;
        while (temp > 0) { // 3001 = 300
            int r = temp % 10;
            freq.put(r, freq.getOrDefault(r, 0) + 1);
            temp = temp / 10;
        }

        for (int k : freq.keySet()) {
            if (k != freq.get(k)) {
                return false;
            }
        }

        return true;
    }
}
