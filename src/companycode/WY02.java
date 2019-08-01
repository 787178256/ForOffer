package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-01
 */
public class WY02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] points = new int[n];
        boolean[] isWake = new boolean[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            points[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            isWake[i] = in.nextInt() == 1;
            if (isWake[i]) {
                sum += points[i];
            }
        }
        int max = 0;
        int s = 0;
        int start = 0, end = 0;
        while (start < n) {
            if (isWake[start]) {
                start++;
                continue;
            }
            while (end < n && end - start + 1 <= k) {
                s += isWake[end] ? 0 : points[end];
                end++;
            }
            max = Math.max(max, s);
            s -= points[start];
            start++;
        }
        System.out.println(sum + max);
    }
}
