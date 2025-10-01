class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles; // D
        int emptyWB = numBottles;

        while (emptyWB >= numExchange) {
            // E
            int newWB = emptyWB / numExchange; // 15 % 4 = 3
            result += newWB;
            emptyWB = newWB + (emptyWB % numExchange);
        }

        return result;
    }
}
