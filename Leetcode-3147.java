class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] answer = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int ni = i + k;

            if (ni >= n) {
                answer[i] = energy[i];
            } else {
                answer[i] = energy[i] + answer[ni];
            }
        }

        int maxEnergy = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxEnergy = Math.max(maxEnergy, answer[i]);
        }

        return maxEnergy;
    }
}
