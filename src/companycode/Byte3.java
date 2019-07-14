package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-07-14
 */
public class Byte3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[][] PR = new int[T][7];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 7; j++) {
                PR[i][j] = in.nextInt();
            }
        }
        for (int[] nums : PR) {
            System.out.println(func(nums));
        }
    }

    private static int func(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int len = nums.length;
        int a = sum % len;
        int avg = sum / len;
        int max1 = 1;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                avg = avg + a;
            }
            max1 = max1 * avg;
        }
        return max1;
    }
}
