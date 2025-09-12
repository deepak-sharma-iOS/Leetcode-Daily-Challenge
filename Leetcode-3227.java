class Solution {
    public boolean doesAliceWin(String s) {
        String vowels = "aeiou";
        int vCount = 0;

        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vCount += 1;
            }
        }

        return vCount > 0;

    }
}
