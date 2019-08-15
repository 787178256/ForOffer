package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-08-15
 */
public class _0892_Surface_Area {
    private int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    res += grid[i][j] * 4 + 2;
                    if (i < grid.length - 1) {
                        res -= Math.min(grid[i][j], grid[i + 1][j]) * 2;
                    }
                    if (j < grid[0].length - 1) {
                        res -= Math.min(grid[i][j], grid[i][j + 1]) * 2;
                    }
                }

            }
        }
        return res;
    }

    @Test
    public void test() {
        int[][] grid = {{1,0}, {0,2}};
        System.out.println(surfaceArea(grid));
    }
}
