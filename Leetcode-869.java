class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] input = countDigits(n);

        for (int i = 0; i < 31; i++) {
            int power = 1 << i;
            int[] pArray = countDigits(power);

            if (matches(input, pArray)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        } 
        return true;
    }

    private int[] countDigits(int n) {
        int num = n;
        int[] count = new int[10];

        // 821
        while (num > 0) {
           count[num % 10] += 1; 
           num = num / 10;
        }

        return count;
    }
}
