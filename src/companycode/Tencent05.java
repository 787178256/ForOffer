package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-17
 */
public class Tencent05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int L = in.nextInt();
        int[] nums = new int[L + 1];
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            nums[start] = end - start;
        }
        int end = 0, maxPosition = 0, steps = 0;
        for (int i = 0; i < L; i++) {
            if (i > maxPosition) {
                System.out.println(-1);
                return;
            }
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        if (maxPosition < L + 1) {
            System.out.println(-1);
            return;
        }
        System.out.println("maxPosition = " + maxPosition);
        System.out.println(steps);
    }
}