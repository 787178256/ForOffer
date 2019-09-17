package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-09-17
 */
public class 百度1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int j = 0; j < T; j++) {
            int n = in.nextInt();
            int m = in.nextInt();
            TreeMap<Integer, List<Integer>> map = new TreeMap<>();
            for (int i = 0; i < m; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                if (map.containsKey(from)) {
                    map.get(from).add(to);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(to);
                    map.put(from, list);
                }
                if (map.containsKey(to)) {
                    map.get(to).add(from);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(from);
                    map.put(to, list);
                }
            }
            System.out.println(solution(map, n));
        }
    }

    private static String solution(TreeMap<Integer, List<Integer>> map, int n) {
        if (!map.containsKey(1)) {
            return "IMPOSSIBLE";
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int layer = 1;
        int c = 1;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            c--;
            if (layer > 3) {
                break;
            }
            if (curIndex == n) {
                return "POSSIBLE";
            }
            List<Integer> list = map.get(curIndex);
            if (list != null) {
                for (int i : list) {
                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            if (c == 0) {
                c = queue.size();
                layer++;
            }
        }
        return "IMPOSSIBLE";
    }
}
