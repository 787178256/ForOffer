package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-15
 */
public class 信用卡中心 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                int j = i + 1;
                while (j < n && s.charAt(j) != 'L') {
                    j++;
                }
                int k = j - i;
                if (k % 2 == 0) {
                    nums[j]++;
                } else {
                    nums[j - 1]++;
                }
            } else if (s.charAt(i) == 'L') {
                int j = i - 1;
                while (j >= 0 && s.charAt(j) != 'R') {
                    j--;
                }
                int k = i - j;
                if (k % 2 == 0) {
                    nums[j]++;
                } else {
                    nums[j + 1]++;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                System.out.print(nums[i] + " ");
            } else {
                System.out.println(nums[i]);
            }
        }
    }
}
