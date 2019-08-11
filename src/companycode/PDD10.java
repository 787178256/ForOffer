package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-08-11
 */
public class PDD10 {
    private static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 山的个数
        int M = in.nextInt(); // 第三种山路的数量
        if (M == 0) {
            System.out.println(N);
            return;
        }
        int[][] path = new int[M][2];
        boolean[][] u = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            path[i][0] = in.nextInt();
            path[i][1] = in.nextInt();
            u[path[i][0]][path[i][1]] = true;
        }
        int num = 0;
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                num++;
                dfs(u, 1, N);
            }
        }
        System.out.println(N - set.size() + num);
    }

    private static void dfs(boolean[][] path, int start, int N) {
        for (int i = start; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (path[i][j]) {
                    set.add(i);
                    dfs(path, j, N);
                }
            }
        }
    }
}
