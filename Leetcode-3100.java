class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles; // D
        int emptyWB = numBottles;

        while (emptyWB >= numExchange) {
            emptyWB = emptyWB - numExchange; // 8 - 2
            numExchange += 1;
            result += 1;
            emptyWB += 1;
        }

        return result;
    } 
}
