package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-07-11
 */
public class Byte_MaxAreaOfIsland {
    private int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int max = 0, curArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    dfs(rows, cols, i, j, visited, grid);
                    print(visited);
                    int increaseArea = getArea(visited) - curArea;
                    System.out.println("increaseArea=" + increaseArea);
                    max = Math.max(increaseArea, max);
                    System.out.println("max=" + max);
                    System.out.println("--------------");
                    curArea = getArea(visited);
                }
            }
        }
        return max;
    }

    private void print(boolean[][] visited) {
        for (boolean[] v : visited) {
            for (boolean c : v) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private int getArea(boolean[][] visited) {
        int area = 0;
        for (boolean[] v : visited) {
            for (boolean c : v) {
                if (c) {
                    area++;
                }
            }
        }
        return area;
    }

    private void dfs(int rows, int cols, int row, int col, boolean[][] visited, int[][] grid) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        dfs(rows, cols, row+1, col, visited, grid);
        dfs(rows, cols, row-1, col, visited, grid);
        dfs(rows, cols, row, col+1, visited, grid);
        dfs(rows, cols, row, col-1, visited, grid);
    }

    @Test
    public void test() {
        int[][] grid = new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}};
        Assert.assertEquals(maxAreaOfIsland(grid), 4);
    }
}
