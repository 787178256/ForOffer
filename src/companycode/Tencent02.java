package companycode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-04-05
 */
public class Tencent02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums, Collections.reverseOrder());
        int scoreA = 0, scoreB = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (!flag) {
                scoreA += nums[i];
                flag = true;
            } else {
                scoreB += nums[i];
                flag = false;
            }
        }
        System.out.println(scoreA - scoreB);
    }
}
