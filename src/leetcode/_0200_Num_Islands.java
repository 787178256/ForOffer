package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-07-02
 */
public class _0200_Num_Islands {
    private int numIslands(char[][] grids) {
        if (grids == null || grids.length == 0) {
            return 0;
        }
        int res = 0;
        int rows = grids.length;
        int cols = grids[0].length;
        boolean[][] visited = new boolean[rows][cols]; // false
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grids[i][j] != '0') {
                    dfs(grids, i, j, rows, cols, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grids, int curRow, int curCol, int rows, int cols, boolean[][] visited) {
        if (curCol < 0 || curRow < 0 ||curCol >= cols || curRow >= rows || grids[curRow][curCol] == '0' || visited[curRow][curCol]) {
            return;
        }
        visited[curRow][curCol] = true;
        dfs(grids, curRow + 1, curCol, rows, cols, visited);
        dfs(grids, curRow - 1, curCol, rows, cols, visited);
        dfs(grids, curRow, curCol + 1, rows, cols, visited);
        dfs(grids, curRow, curCol - 1, rows, cols, visited);
    }

    @Test
    public void test() {
        char[][] grids = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        char[][] grid = {{'0'}};
        Assert.assertEquals(1, numIslands(grids));
        Assert.assertEquals(0, numIslands(grid));
    }

}
