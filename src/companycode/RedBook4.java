package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-18
 */
public class RedBook4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //N只魔物
        int T = in.nextInt(); //T个回合
        int M = in.nextInt(); //M点法力
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = in.nextInt();
        }
        Arrays.sort(H);
        if (N > T) {
            System.out.print(-1);
            return;
        }
        if (N == T) {
            if (M < T && H[N - M] > 1) {
                System.out.println(-1);
                return;
            }
        }

    }

    private void dfs(int T, int SUM, int M) {

    }
}
