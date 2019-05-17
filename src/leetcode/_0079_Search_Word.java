package leetcode;


/**
 * Created by kimvra on 2019-05-17
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class _0079_Search_Word {
    public static boolean exist(char[][] board, String word) {
        if (word == null || word.trim().length() == 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] used = new boolean[rows][cols];

        boolean res = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res = res || func(i, j, rows, cols, board, word, 0, used);
                }
            }
        }

        return res;

    }

    private static boolean func(int indexX, int indexY, int rows, int cols, char[][] board, String word, int index, boolean[][] used) {
        if (index == word.length()) {
            return true;
        }

        if (indexX < 0 || indexX >= rows || indexY < 0 || indexY >= cols || used[indexX][indexY] || board[indexX][indexY] != word.charAt(index)) {
            return false;
        }

        used[indexX][indexY] = true;

        if (func(indexX + 1, indexY, rows, cols, board, word, index + 1, used) ||
                func(indexX - 1, indexY, rows, cols, board, word, index + 1, used) ||
                func(indexX, indexY + 1, rows, cols, board, word, index + 1, used) ||
                func(indexX, indexY - 1, rows, cols, board, word, index + 1, used)) {
            return true;
        }
        // 关键：对不符合的路径上元素 重置为false
        used[indexX][indexY] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {  {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}
        };

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }
}
