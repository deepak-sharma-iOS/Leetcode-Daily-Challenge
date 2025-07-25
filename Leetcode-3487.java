class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        int result = 0;
        int maxNegativeValue = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > 0) {
                uniqueElements.add(num);
            } else {
                maxNegativeValue = Math.max(maxNegativeValue, num);
            }
        }

        for (int num : uniqueElements) {
            result += num;
        }

        return result == 0 ? maxNegativeValue : result;
        
    }
}
