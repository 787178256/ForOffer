package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-01
 */
public class WY03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
            if (i == 0) {
                s[i] = nums[i];
            } else {
                s[i] = s[i - 1] + nums[i];
            }
        }
        int[] res = new int[sum + 1];
        for (int i = 1; i <= sum;) {
            for (int j = 0; j < n; j++) {
                while (i <= s[j]) {
                    res[i++] = j + 1;
                }
            }
        }
        int m = in.nextInt();
        int[] apple = new int[m];
        for (int i = 0; i < m; i++) {
            apple[i] = in.nextInt();
            System.out.println(res[apple[i]]);
        }
    }
}
