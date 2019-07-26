package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-07-26
 */
public class _0547_Find_Cycle_Num {
    private int findCycleNum(int[][] M) {
        int n = M.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, M, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, int[][] M, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < M[i].length; j++) {
            if (!visited[j] && M[i][j] == 1) {
                dfs(j, M, visited);
            }
        }
    }

    @Test
    public void test() {
        int[][] M = {   {1,0,0,1},
                        {0,1,1,0},
                        {0,1,1,1},
                        {1,0,1,1}
                    };
        Assert.assertEquals(1, findCycleNum(M));
    }
}
