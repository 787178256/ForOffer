package leetcode;

import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

/**
 * Created by kimvra on 2019-03-14
 */
public class _0554_Least_Bricks {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                Integer val = map.get(sum);
                map.put(sum, val == null ? 1 : ++val);
            }
        }
        int max = 0;
        for (Integer integer : map.values()) {
            if (integer > max) {
                max = integer;
            }
        }
        return wall.size() - max;
    }


}
