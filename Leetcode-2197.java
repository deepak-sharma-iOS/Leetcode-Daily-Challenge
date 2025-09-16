class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            stack.add(num);

            while (stack.size() >= 2) {
                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);

                int g = gcd(a, b);

                if (g > 1) {
                    long l = (long) a / g * b;
                    stack.add((int) l);
                } else {    
                    stack.add(a);
                    stack.add(b);
                    break;
                }
            }
        }

        return stack;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
