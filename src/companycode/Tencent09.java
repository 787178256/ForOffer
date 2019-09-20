package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-20
 */
public class Tencent09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][2];
        int M = 0;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            matrix[i][0] = in.nextInt();
            matrix[i][1] = in.nextInt();
            M += matrix[i][0];
            cost += matrix[i][1] * matrix[i][0];
        }
        System.out.println(cost * 2 / M);
    }
}
