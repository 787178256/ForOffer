package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-09-21
 */
public class EA {
    static TreeMap<Integer, Boolean> res = new TreeMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strings = line.split(" ");
        int N = Integer.valueOf(strings[0]);
        int M = Integer.valueOf(strings[1]);
        int C = Integer.valueOf(strings[2]);
        int[][] cost = new int[M][4];
        int[][] distance = new int[N][N];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 2; i <= M + 1; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int len = in.nextInt();
            int pay = in.nextInt();
            cost[start][end] = pay;
            distance[start][end] = len;
            if (map.containsKey(start)) {
                map.get(start).add(end);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(end);
                map.put(start, list);
            }
        }
        dfs(0, C, cost, distance, N, 0, map);
        for (Map.Entry<Integer, Boolean> entry : res.entrySet()) {
            if (entry.getValue()) {
                System.out.println(entry.getKey());
                return;
            } else {
                System.out.println(-1);
                return;
            }
        }
    }

    private static void dfs(int start, int C, int[][] cost, int[][] distance, int N, int p, HashMap<Integer, List<Integer>> map) {
        if (start == N - 1) {
            if (C >= 0) {
                res.put(p, true);
            } else {
                res.put(p, false);
            }
            return;
        }
        if (C < 0) {
            return;
        }
        if (!map.containsKey(start)) {
            return;
        }
        List<Integer> list = map.get(start);
        for (int i = 0; i < list.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Boolean> entry : res.entrySet()) {
                if (entry.getValue()) {
                    min = entry.getKey();
                }
                break;
            }
            if (min <= p) {
                break;
            }
            int end = list.get(i);
            dfs(end, C - cost[start][end], cost, distance, N, p + distance[start][end], map);
        }
    }
}
