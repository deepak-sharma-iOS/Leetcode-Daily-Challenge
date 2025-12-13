class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        String[] order = {"electronics", "grocery", "pharmacy", "restaurant"};
        Set<String> validCategory = new HashSet<>(Arrays.asList(order));

        Map<String, List<String>> map = new HashMap<>();
        for (String c : order) {
            map.put(c, new ArrayList<>());
        }
 
        for (int i = 0; i < n; i++) {
            String c = code[i];

            if (c == null || c.isEmpty() || !c.matches("[a-zA-Z0-9_]+")) {
                continue;
            }

            String bl = businessLine[i];
            if (!validCategory.contains(bl)) {
                continue;
            }

            if (!isActive[i]) {
                continue;
            }

            map.get(bl).add(c);
        }

        for (String c : order) {
            Collections.sort(map.get(c));
        }

        List<String> result = new ArrayList<>();
        for (String c : order) {
            result.addAll(map.get(c));
        }

        return result;
    }
}
