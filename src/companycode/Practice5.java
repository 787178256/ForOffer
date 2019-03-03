package companycode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-02-28
 */
public class Practice5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        char[][] mmap = new char[M][N];
        for (int i = 0; i < M; i++) {
            String input = in.next();
            for (int j = 0; j < N; j++) {
                mmap[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mmap[i][j] == '2') {
                    System.out.println(solution(mmap, i, j));
                }
            }
        }
    }

    public static int solution(char[][] mmap, int startX, int startY) {
        int count = 0;
        int m = mmap.length;
        int n = mmap[0].length;
        boolean[][][] isVisited = new boolean[m][n][1024];
        isVisited[startX][startY][0] = true;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startX);
        queue.offer(startY);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int num = queue.size() / 3;
            count++;
            while (num > 0) {
                startX = queue.poll();
                startY = queue.poll();
                int k = queue.poll();
                num--;
                for (int i = 0; i < 4; i++) {
                    int x = startX + dir[i][0];
                    int y = startY + dir[i][1];
                    int key = k;
                    if (x < 0 || x >= m || y < 0 || y >= n || mmap[x][y] == '0') {
                        continue;
                    } else if (mmap[x][y] == '3') {
                        return count;
                    } else if (mmap[x][y] <= 'j' && mmap[x][y] >= 'a') {
                        key = key | 1 << mmap[x][y] - 'a';
                    } else if (mmap[x][y] <= 'J' && mmap[x][y] >= 'A' && (key & 1 << mmap[x][y] - 'A') == 0) {
                        continue;
                    }
                    if (isVisited[x][y][key] = false) {
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
