// 3346
import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int maxNum = nums[nums.length - 1];

        int ans = 0;
        for (int target = 1; target <= maxNum; target++) {
            ans = Math.max(ans, maximumFreq(target, nums, freq, k, numOperations));
        }

        return ans;
    }

    private int maximumFreq(int target, int[] nums, Map<Integer, Integer> freq, int k, 
    int numOperations) {
        int left = getIndex(nums, target - k);
        int right = getIndex(nums, target + k + 1);
        int operations = right - left - freq.getOrDefault(target, 0);

        return Math.min(operations, numOperations) + freq.getOrDefault(target, 0);
    }

    private int getIndex(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}

// 3347
import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        Set<Integer> candidates = new HashSet<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);

            candidates.add(n);
            candidates.add(n + k);
            candidates.add(n - k);
        }

        int ans = 0;
        for (int target : candidates) {
            ans = Math.max(ans, maximumFreq(target, nums, freq, k, numOperations));
        }

        return ans;
    }

    private int maximumFreq(int target, int[] nums, Map<Integer, Integer> freq, int k, 
    int numOperations) {
        int left = getIndex(nums, target - k);
        int right = getIndex(nums, target + k + 1);
        int operations = right - left - freq.getOrDefault(target, 0);

        return Math.min(operations, numOperations) + freq.getOrDefault(target, 0);
    }

    private int getIndex(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
