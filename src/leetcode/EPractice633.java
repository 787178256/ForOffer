package leetcode;

/**
 * Created by kimvra on 2019-03-08
 */
public class EPractice633 {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum < c) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }
}
