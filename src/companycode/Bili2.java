package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-10
 */
public class Bili2 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            int j = i;
            while (sum < N) {
                sum += j;
                j++;
            }
            if (sum == N) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int target, int curSum, int index) {
        if (target == curSum) {
            count++;
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = index; i < target; i++) {
            if (curSum + i > target) {
                break;
            }
            dfs(target, curSum + i, i + 1);
        }
    }
}
