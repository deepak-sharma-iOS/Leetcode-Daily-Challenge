class Solution {
    public int countOdds(int low, int high) {
        int total = high - low + 1;
        int ans = total / 2;

        if (high % 2 == 1 && low % 2 == 1) {
            ans += 1;
        }
 
        return ans;
    }
}
