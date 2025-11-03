class Solution {
    public int minCost(String colors, int[] neededTime) {
        int prev = 0, cur = 1, result = 0;
        char[] cArray = colors.toCharArray();

        while (cur < cArray.length) {
            if (cArray[cur] == cArray[prev]) {
                result += Math.min(neededTime[cur], neededTime[prev]);

                if (neededTime[cur] > neededTime[prev]) {
                    prev = cur;
                }
            } else {
                prev = cur;
            }

            cur += 1;
        }

        return result;
    }
}
