class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        // -ve
        StringBuilder result = new StringBuilder();
        if (numerator < 0 && denominator > 0) {
            result.append("-");
        } else if (denominator < 0 && numerator > 0) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // 4 / 2 = 2
        result.append(num / den);
        num = num % den;

        if (num == 0) {
            return result.toString();
        }

        result.append(".");

        // 10 / 9 -> 10 / 9 -> 1
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, result.length());

        while (num != 0) {
            num = num * 10;
            result.append(num / den);
            num = num % den;

            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                map.put(num, result.length());
            }
        }

        return result.toString();
    }
}
