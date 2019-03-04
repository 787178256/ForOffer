package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-03-04
 */
public class HW13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Map<Integer, Integer> map = new TreeMap<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int key = in.nextInt();
                int value = in.nextInt();
                if (map.containsKey(key)) {
                    int oldValue = map.get(key);
                    map.put(key, oldValue + value);
                } else {
                    map.put(key, value);
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
