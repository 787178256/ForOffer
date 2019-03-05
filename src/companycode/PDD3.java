package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-05
 */
public class PDD3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = in.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        int count = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - m + i; j >= 0; j--) {
                if (w[i] >= h[j] && h[j] >= 0) {
                    h[j] = -1;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
