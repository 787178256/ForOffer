package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-05
 */
public class PDD1 {
    public static long findMultiMax(long[] array) {
        Arrays.sort(array);
        int len = array.length;
        if (len == 3) {
            return array[0] * array[1] * array[2];
        }
        if (array[len - 1] < 0 || array[0] > 0) {
            return array[len - 1] * array[len - 2] * array[len - 3];
        }
        long sum1 = array[len - 1] * array[len - 2] * array[len - 3];
        long sum2 = array[0] * array[1] * array[len - 1];
        return sum1 > sum2 ? sum1 : sum2;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] array = new long[n];
        for (int i = 0 ; i < n; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(findMultiMax(array));
    }
}
