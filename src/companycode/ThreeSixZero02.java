package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-10
 */
public class ThreeSixZero02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int max = nums[0] > nums[1] ? nums[0] : nums[1];
        int sum = nums[0] + nums[1];
        for (int i = 2; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
            if (sum - max > max) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }
}
