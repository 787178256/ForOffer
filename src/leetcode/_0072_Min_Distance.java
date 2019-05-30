package leetcode;

/**
 * Created by kimvra on 2019-05-29
 */
public class _0072_Min_Distance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] cost = new int[m+1][n+1];//cost[i][j]表示word1[0...i-1]到word2[0...j-1]的步数
        for (int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            cost[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    cost[i][j] = cost[i-1][j-1];
                } else {
                    cost[i][j] = 1 + Math.min(cost[i-1][j-1], Math.min(cost[i][j-1], cost[i-1][j]));
                }
            }
        }
        return cost[m][n];
    }

    private static int reviewSolution(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] cost = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            cost[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cost[i][j] = cost[i-1][j-1];
                } else {
                    cost[i][j] = Math.min(cost[i-1][j-1], Math.min(cost[i][j-1], cost[i-1][j])) + 1;
                }
            }
        }
        return cost[m][n];
    }

    public static void main(String[] args) {
//        System.out.println(minDistance("horse", "ros"));
//        System.out.println(minDistance("intention", "execution"));
        System.out.println(reviewSolution("horse", "ros"));
    }
}
