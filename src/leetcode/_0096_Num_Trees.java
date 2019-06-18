package leetcode;

/**
 * Created by kimvra on 2019-06-18
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class _0096_Num_Trees {
    private static int numTrees(int n) {
        int[] f = new int[n+1];
        if (n < 3) {
            return n;
        }
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 0; j <= i - 1; j++) {
                f[i] += f[j] * f[i - 1- j];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(1));
    }
}
