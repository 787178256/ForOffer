package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-08-11
 */
public class PDD12 {
    static int count = 0;

    public static void main(String[] args) {
        int N, M;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Set<Integer> set;
            if (map.containsKey(a)) {
                set = map.get(a);
            } else {
                set = new TreeSet<>();
            }
            set.add(b);
            map.put(a, set);
        }
        Map<Integer, Integer> visitMap = new HashMap();
        for (int index : map.keySet()) {
            findPath(map, visitMap, index);
        }
        int ret =  count + N - visitMap.size();
        System.out.println(ret);
    }

    private static void findPath(Map<Integer, Set<Integer>> map, Map<Integer, Integer> visitMap, int index) {
        if (!map.containsKey(index)) {
            ++count;
            visitMap.put(index, 1);
            return;
        }
        visitMap.put(index, 1);
        for (int next : map.get(index)) {
            if (!visitMap.containsKey(index)) {
                findPath(map, visitMap, next);
            }
        }
    }

}
