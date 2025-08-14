class Solution {
    public String largestGoodInteger(String num) {
        char prev = 'A';
        int count = 0;
        char maxD = ' '; // 32 // 

        for (char current : num.toCharArray()) {
            if (current == prev) {
                count += 1;
            } else {
                count = 1;
            }

            if (count == 3) {
               maxD = (char) Math.max(maxD, current);
            }

            prev = current;
        }

        if (maxD == ' ') {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            result.append(maxD);
        }

        return result.toString();
    }
}
