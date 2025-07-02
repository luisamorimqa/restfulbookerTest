package utils;

import java.util.HashMap;
import java.util.Map;

public class SharedData {

    private static final Map<String, Object> dataMap = new HashMap<>();

    public static <T> void set(String key, T value) {
        dataMap.put(key, value);
    }

    public static <T> T get(String key) {
        return (T) dataMap.get(key);
    }

    public static void clear() {
        dataMap.clear();
    }
}