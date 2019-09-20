package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-20
 */
public class Tencent08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            Arrays.sort(nums);
            int j = 0;
            while (j < n && nums[j] <= 0) {
                j++;
            }
            if (j < n) {
                System.out.println(nums[j]);
            } else {
                System.out.println(0);
            }
            int t = nums[j];
            for (int s = 0; s < n; s++) {
                if (nums[s] > 0 && t > 0) {
                    nums[s] = nums[s] - t;
                }
            }
        }
    }
}
