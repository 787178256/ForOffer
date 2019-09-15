package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-15
 */
public class Byte08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 3) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int k = in.nextInt();
//        int k = 2;
//        int[] nums = new int[]{-2,0,1,2,3,6};
//        int n = 6;
        Arrays.sort(nums);
        int min = nums[0];
        if (min >= k) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < k) {
                    count += right - left;
                    left++;
                }
                if (sum >= k) {
                    --right;
                }
            }
        }
        System.out.println(count);
    }
}
