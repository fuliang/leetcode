import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by fuliang on 2015/4/28.
 */
public class LRUCache {
    private Map<Integer, Integer> cache;

    public LRUCache(final int capacity) {

        cache = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer value = cache.get(key);
        return value == null ? -1 : value;
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }
}
