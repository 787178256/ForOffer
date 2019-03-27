package pat;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-25
 */
public class DFS {
    private static int maxValue = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int V = in.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
        }
        dfs(0, n, 0, 0, V, weight, value);
        System.out.println("maxValue:" + maxValue);
    }

    private static void dfs(int index, int n, int sumW, int sumC, int V, int[] weight, int[] value) {
        if (index == n) {
            return;
        }

        dfs(index + 1, n, sumW, sumC, V, weight, value);
        if (sumW + weight[index] <= V) {
            if (sumC + value[index] > maxValue) {
                maxValue = sumC + value[index];
            }
            dfs(index + 1, n, sumW + weight[index], sumC + value[index], V, weight, value);
        }

    }
}
