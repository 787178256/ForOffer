package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-09-15
 */
public class 信用卡中心2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n + 1][n + 1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            if (map.get(u) == null) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(v);
                map.put(u, list1);
            } else {
                map.get(u).add(v);
            }
            int c = in.nextInt();
            matrix[u][v] = c;
        }
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                System.out.print(solution(i, map, matrix));
            } else {
                System.out.print(solution(i, map, matrix) + " ");
            }
        }
    }

    private static int solution(int index, HashMap<Integer, List<Integer>> map, int[][] matrix) {
        if (map.get(index) == null) {
            return 0;
        }
        List<Integer> list = map.get(index);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(solution(list.get(i), map, matrix) + matrix[index][list.get(i)], max);
        }
        return max;
    }
}
