package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-11
 */
public class PDD9 {
    private static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        func(0, 0, S, N, 1);
        System.out.println(res);
    }

    private static void func(int count, int sum, int S, int N, int index) {
        if (count == N && sum == S) {
            res++;
            return;
        }
        if (count >= N || sum >= S) {
            return;
        }
        for (int i = index; i <= S; i++) {
            if (sum + i > S) {
                continue;
            }
            func(count + 1, sum + i, S, N, i + 1);
        }
    }
}
