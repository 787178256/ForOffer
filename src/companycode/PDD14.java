package companycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-01
 *
 * 第k大就是
 */
public class PDD14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //宽
        int m = in.nextInt(); //高
        int k = in.nextInt(); //查询的值
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = (i + 1) * (j + 1);
            }
        }
        int count = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (count == k) {
                    System.out.println(nums[i][j]);
                    return;
                } else {

                }
            }
        }
    }
}
