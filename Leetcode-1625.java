class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        String smallest = s;
        visited.add(s);
        q.offer(s);

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (cur.compareTo(smallest) < 0) {
                smallest = cur;
            }

            // 1 = a / 9 + 5 = 14
            char[] chars = cur.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
            }
            String str = new String(chars);
            if (visited.add(str)) {
                q.offer(str);
            }

            // R = 1234 - 2
            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (visited.add(rotated)) {
                q.offer(rotated);
            }
        }

        return smallest;
    }
} 
