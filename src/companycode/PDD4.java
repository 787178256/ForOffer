package companycode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-05
 */
public class PDD4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        char[][] maze = new char[m][n];
        in.nextLine();
        for (int i = 0; i < m; i++) {
            maze[i] = in.nextLine().toCharArray();
        }
        in.close();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j]== '2') {
                    System.out.println(solution(maze, i, j));
                }
            }
        }
    }

    private static int solution(char[][] maze, int startX, int startY) {
        int res = 0;
        int m = maze.length;
        int n = maze[0].length;
        boolean[][][] isVisited = new boolean[m][n][1024];
        isVisited[startX][startY][0] = true;
        int[][] dir = {{-1,0}, {1,0},{0,1},{0,-1}};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startX);
        queue.offer(startX);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int num = queue.size() / 3;
            res++;
            while (num > 0) {
                startX = queue.poll();
                startY = queue.poll();
                int k = queue.poll();
                num--;
                for (int i = 0; i < 4; i++) {
                    int x = startX + dir[i][0];
                    int y = startY + dir[0][i];
                    int key = k;
                    if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '0') {
                        continue;
                    } else if (maze[x][y] == '3') {
                        return res;
                    } else if (maze[x][y] <= 'j' && maze[x][y] >= 'a') {
                        key = key | 1 << maze[x][y] - 'a';
                    } else if (maze[x][y] <= 'J' && maze[x][y] >= 'A' && (key & 1 << maze[x][y] - 'A') == 0) {
                        continue;
                    }
                    if (!isVisited[x][y][key]) {
                        isVisited[x][y][key] = true;
                        queue.offer(x);
                        queue.offer(y);
                        queue.offer(key);
                    }
                }
            }
        }
        return -1;
    }
}
