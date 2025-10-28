class Solution {
    public int countValidSelections(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (allZeros(nums, 1, i)) {
                    result += 1;
                }

                if (allZeros(nums, -1, i)) {
                    result += 1;
                }
            }
        }

        return result;
    }

    private boolean allZeros(int[] nums, int dir, int start) {
        int[] arr = nums.clone();
        int direction = dir;
        int curr = start;

        while (curr >= 0 && curr < arr.length) {
            if (arr[curr] == 0) {
                curr += direction;
            } else {
                arr[curr] -= 1;
                direction = -direction;
                curr += direction;
            }
        }

        for (int x : arr) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }
}
