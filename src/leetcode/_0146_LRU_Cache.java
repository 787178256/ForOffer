package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by kimvra on 2019-06-24
 */
public class _0146_LRU_Cache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.print();
    }
}
class LRUCache{

    private LinkedHashMap<Integer, Integer> map;

    private float loadFactor = 0.8f;

    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(this.capacity, loadFactor, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            return;
        }
        if (map.size() == capacity) {
            boolean isFirst = true;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (isFirst) {
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
        map.put(key, value);
    }

    public void print() {
        System.out.println(map);
    }
}
