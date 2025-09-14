class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            exact.add(word);

            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(convertVowel(lower), word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exact.contains(q)) {
               result[i] = q;
               continue; 
            }

            String lower = q.toLowerCase();
            if (caseInsensitive.containsKey(lower)) {
                result[i] = caseInsensitive.get(lower);
                continue;
            }

            String cVowel = convertVowel(lower);
            if (vowelInsensitive.containsKey(cVowel)) {
                result[i] = vowelInsensitive.get(cVowel);
                continue;
            }

            result[i] = "";
        }

        return result;
    }

    // abcd = bcd
    private String convertVowel(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                result.append("*");
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
