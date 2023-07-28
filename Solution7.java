import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> values = map.get(key);
        Integer floorTimestamp = values.floorKey(timestamp);
        if (floorTimestamp == null) {
            return "";
        }
        return values.get(floorTimestamp);
    }
}

public class Solution7 {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));  // Output: "bar"
        System.out.println(timeMap.get("foo", 3));  // Output: "bar"
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));  // Output: "bar2"
        System.out.println(timeMap.get("foo", 5));  // Output: "bar2"
    }
}
