class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        Arrays.fill(online, true);
        Map<Integer, Integer> backToOnline = new HashMap<>();

        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 != t2) { return t1 - t2; }

            boolean m1 = a.get(0).equals("MESSAGE");
            boolean m2 = b.get(0).equals("MESSAGE");

            return Boolean.compare(m1, m2);
        });

        for (List<String> e : events) {
            String type = e.get(0);
            int t = Integer.parseInt(e.get(1));
            String data = e.get(2);

            for (int u = 0; u < numberOfUsers; u++) {
                if (!online[u]) {
                    int backTime = backToOnline.getOrDefault(u, -1);
                    if (backTime != -1 && t >= backTime) {
                        online[u] = true;
                        backToOnline.put(u, -1);
                    }
                }
            }

            if (type.equals("OFFLINE")) {
                int user = Integer.parseInt(data);
                online[user] = false;
                backToOnline.put(user, t + 60);
                continue;
            }

            for (String s : data.split(" ")) {
                if (s.equals("ALL")) {
                    for (int u = 0; u < numberOfUsers; u++) {
                        mentions[u] += 1;
                    }
                } else if (s.equals("HERE")) {
                    for (int u = 0; u < numberOfUsers; u++) {
                        if (online[u]) {
                            mentions[u] += 1;
                        }
                    }
                } else if (s.startsWith("id") && s.length() > 2) {
                    int user = Integer.parseInt(s.substring(2));
                    mentions[user] += 1;
                }
            }
        }
        
        return mentions;
    }
}
