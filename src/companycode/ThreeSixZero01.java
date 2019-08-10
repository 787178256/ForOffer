package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-10
 */
public class ThreeSixZero01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] x = new long[N];
        long[] y = new long[N];
        for (int i = 0; i < N; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        Arrays.sort(x);
        Arrays.sort(y);
        long xLen = x[N - 1] - x[0];
        long yLen = y[N - 1] - y[0];
        long res = Math.max(xLen, yLen) * Math.max(xLen, yLen);
        System.out.println(res);
    }
}
