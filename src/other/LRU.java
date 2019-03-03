package other;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by kimvra on 2019-02-27
 */
public class LRU<K, V> extends LinkedHashMap<K, V> {
    private int CACHE_SIZE;

    public LRU(int cacheSize) {
        super((int)Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        this.CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
