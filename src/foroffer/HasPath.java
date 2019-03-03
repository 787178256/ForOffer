package foroffer;

/**
 * Created by kimvra on 2019-02-27
 */
public class HasPath {
    public boolean solution(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (findPath(matrix, rows, cols, i, j, 0, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findPath(char[] matrix, int rows, int cols, int r, int c, int index, char[] str, boolean[] visited) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || matrix[r * cols + c] != str[index] || visited[r * cols + c]) {
            return false;
        }
        if (index == str.length - 1) {
            return true;
        }
        visited[r * cols + c] = true;
        if (findPath(matrix, rows, cols, r + 1, c, index + 1, str, visited) ||
        findPath(matrix, rows, cols, r - 1, c, index + 1, str, visited) ||
        findPath(matrix, rows, cols, r, c + 1, index + 1, str, visited) ||
        findPath(matrix, rows, cols, r, c - 1, index + 1, str, visited)) {
            return true;
        }
        visited[r * cols + c] = false;
        return false;
    }


}
