package companycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-03
 */
public class 小红书1 {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] matrix = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            matrix[x][y] = 1;
        }
        dfs(0, 0, n, m, matrix, 0, visited);
        if (list.size() == 0) {
            System.out.print(0);
            return;
        }
        Collections.sort(list);
        System.out.print(list.get(0));
    }

    private static void dfs(int curRow, int curCol, int rows, int cols, int[][] matrix, int count, boolean[][] visited) {
        if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols || matrix[curRow][curCol] == 1 || visited[curRow][curCol]) {
            return;
        }
        if (curRow == rows - 1 && curCol == cols - 1) {
            list.add(count);
            return;
        }
        visited[curRow][curCol] = true;
        dfs(curRow - 1, curCol, rows, cols, matrix, count + 1, visited);
        dfs(curRow + 1, curCol, rows, cols, matrix, count + 1, visited);
        dfs(curRow, curCol - 1, rows, cols, matrix, count + 1, visited);
        dfs(curRow, curCol + 1, rows, cols, matrix, count + 1, visited);
        visited[curRow][curCol] = false;
    }
}
