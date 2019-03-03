package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-02-27
 */
public class Practice2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] array = new long[n];
        for (int i = 0 ; i < n; i++) {
            array[i] = in.nextInt();
        }
        getLargestMul(array, n);
    }

    public static void getLargestMul(long[] array, int n) {
        long max1= 0, max2 = 0, max3 = 0, min1 = 0, min2 = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = array[i];
            } else if (array[i] > max2) {
                max3 = max2;
                max2 = array[i];
            } else if (array[i] > max3) {
                max3 = array[i];
            } else if (array[i] < min1) {
                min2 = min1;
                min1 = array[i];
            } else if (array[i] < min2) {
                min2 = array[i];
            }
        }
        long sum1 = max1 * max2 * max3;
        long sum2 = max1 * min1 * min2;
        System.out.println(sum1 > sum2 ? sum1 : sum2);
    }
}
