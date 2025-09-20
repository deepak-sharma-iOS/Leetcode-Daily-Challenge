import java.util.*;

class Router {
    private class Packet {
        int source, destination, timestamp;

        Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }
    }


    private int memoryLimit = 0;
    private ArrayList<Packet> packets = new ArrayList<>();
    private Set<String> set = new HashSet<>();
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    private String getKey(int source, int destination, int timestamp) {
        return source + "_" + destination + "_" + timestamp;
    }

    // 1, 12, 4 -> 1124 -> 1_12_4
    // 11, 2, 4 -> 1124 -> 11_2_4
    public boolean addPacket(int source, int destination, int timestamp) {
        String value = getKey(source, destination, timestamp);

        if (set.contains(value)) {
            return false;
        }

        if (packets.size() == memoryLimit) {
            Packet packet = packets.remove(0);
            String key = getKey(packet.source, packet.destination, packet.timestamp);
            set.remove(key);

            List<Integer> timestamps = map.getOrDefault(packet.destination, new ArrayList<>());
            if (!timestamps.isEmpty()) {
                timestamps.remove(0);
                map.put(packet.destination, timestamps);
            }
        }

        set.add(value);
        packets.add(new Packet(source, destination, timestamp));
        map.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (packets.size() == 0) {
            return new int[0];
        }

        Packet packet = packets.remove(0);
        String key = getKey(packet.source, packet.destination, packet.timestamp);
        set.remove(key);

        List<Integer> timestamps = map.getOrDefault(packet.destination, new ArrayList<>());
        if (!timestamps.isEmpty()) {
            timestamps.remove(0);
            map.put(packet.destination, timestamps);
        }

        return new int[] {packet.source, packet.destination, packet.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> arr = map.getOrDefault(destination, new ArrayList<>());
        int upper = upperBound(arr, endTime);
        int lower = lowerBound(arr, startTime);

        return upper - lower;
    }

    private int lowerBound(List<Integer> arr, int target) {
        int low = 0, high = arr.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int upperBound(List<Integer> arr, int target) {
        int low = 0, high = arr.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
