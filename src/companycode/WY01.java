package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-01
 */
public class WY01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] hash = new int[n + 1];
        for (int i = 0; i < m; i++) {
            hash[in.nextInt()]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (hash[i] < min) {
                min = hash[i];
            }
        }
        System.out.println(min);
    }
}
