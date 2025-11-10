class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int operations = 0;

        for (int n : nums) {
            while (!stack.isEmpty() && stack.peek() > n) {
                stack.pop();
            }

            if (n == 0) {
                continue;
            }


            if (stack.isEmpty() || stack.peek() < n) {
                operations += 1;
                stack.push(n);
            }

        }

        return operations;
    }
}
