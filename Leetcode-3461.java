class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder newString = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int a = s.charAt(i) - '0';
                int b = s.charAt(i + 1) - '0';
                newString.append((a + b) % 10);
            }

            s = newString.toString();
        }

        return s.length() == 2 && s.charAt(0) == s.charAt(1);
    }
}
