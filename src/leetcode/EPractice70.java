package leetcode;

/**
 * Created by kimvra on 2019-03-10
 */
public class EPractice70 {
    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
