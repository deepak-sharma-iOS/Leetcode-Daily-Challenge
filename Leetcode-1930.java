class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);

            if (left != -1 && right != -1 && right - left > 1) {
                boolean[] seen = new boolean[26];

                for (int i = left + 1; i < right; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }

                int count = 0;
                for (boolean b : seen) {
                    if (b) {
                        count += 1;
                    }
                }
                result += count;
            }
        }

        return result;
    }
}
