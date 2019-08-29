package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-08-29
 * 最大连通子图个数
 */
public class 顺丰1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            if (map.containsKey(u)) {
                map.get(u).add(v);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(v);
                map.put(u, list);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (map.containsKey(i) && map.containsKey(j)) {
                    List<Integer> list1 = map.get(i);
                    List<Integer> list2 = map.get(j);
                    list1.retainAll(list2);
                    if (list1.size() != 0) {
                        continue;
                    } else {
                        int ii = 0;
                        for (; ii <= n && ii != i && ii != j; ii++) {
                            if (map.containsKey(ii)) {
                                List<Integer> tempList = map.get(ii);
                                tempList.retainAll(map.get(i));
                                List<Integer> tempList1 = map.get(ii);
                                tempList1.retainAll(map.get(j));
                                if (tempList.size() != 0 && tempList1.size() != 0) {
                                    break;
                                }
                            }
                        }
                        if (ii == n + 1) {
                            count++;
                        }
                    }
                } else if (map.containsKey(i)) {
                    int ii = 0;
                    for (; ii <= n && ii != i && ii != j; ii++) {
                        if (map.containsKey(ii)) {
                            List<Integer> tempList = map.get(ii);
                            tempList.retainAll(map.get(i));
                            if (tempList.size() != 0) {
                                break;
                            }
                        }
                    }
                    if (ii == n + 1) {
                        count++;
                    }
                } else {
                    int ii = 0;
                    for (; ii <= n && ii != i && ii != j; ii++) {
                        if (map.containsKey(ii)) {
                            List<Integer> tempList = map.get(ii);
                            tempList.retainAll(map.get(j));
                            if (tempList.size() != 0) {
                                break;
                            }
                        }
                    }
                    if (ii == n + 1) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
