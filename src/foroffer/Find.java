package foroffer;

/**
 * Created by kimvra on 2019-03-02
 */
public class Find {
    public boolean solution(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean betterSolution(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {
            if (array[row][col] > target) {
                --row;
            } else if (array[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
