package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-03
 *
 */
public class WY4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] qs = new int[q];
        for (int i = 0; i < q; i++) {
            qs[i] = in.nextInt();
        }
        for (int i : qs) {
            int out = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] >= i) {
                    out++;
                    nums[j]--;
                }
            }
            System.out.println(out);
        }
    }

}
