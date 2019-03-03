package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-02-28
 */
public class Practice4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 表示h数组元素个数
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        int m = in.nextInt(); // 表示w数组元素个数
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = in.nextInt();
        }
        System.out.println(solution(h, w));
    }

    private static int solution(int[] children, int[] chocolates) {
        Arrays.sort(children);
        Arrays.sort(chocolates);
        int count = 0;
        for (int i = 0; i < chocolates.length; i++) {
            for (int j = 0; j < children.length; j++) {
                if (children[j] < 0 || chocolates[i] < 0) {
                    continue;
                }
                if (chocolates[i] >= children[j]) {
                    count++;
                    children[j] = -1;
                    chocolates[i] = -1;
                }
            }
        }
        return count;
    }
}
