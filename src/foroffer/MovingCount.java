package foroffer;

/**
 * Created by kimvra on 2019-02-27
 */
public class MovingCount {
    public int solution(int threshold, int rows, int cols) {
        boolean[] visited = new boolean[rows * cols];
        int count = 0;
        canMove(threshold, rows, cols, 0, 0, visited);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }
        return count;
    }

    public void canMove(int threshold, int rows, int cols, int r, int c, boolean[] visited) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || sum(r, c) > threshold || visited[r * cols + c]) {
            return;
        }
        visited[r * cols + c] = false;
        canMove(threshold, rows, cols, r + 1, c, visited);
        canMove(threshold, rows, cols, r - 1, c, visited);
        canMove(threshold, rows, cols, r, c + 1, visited);
        canMove(threshold, rows, cols, r, c - 1, visited);
    }
    public int sum(int a, int b) {
        int result = 0;
        while (a != 0) {
            int a_ = a % 10;
            result = result + a_;
        }
        while (b != 0) {
            int b_ = b % 10;
            b = b / 10;
            result = result + b_;
        }
        return result;
    }
}
