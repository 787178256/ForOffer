package companycode;

import java.util.Scanner;
/**
 * Created by kimvra on 2019-09-15
 */
public class Byte10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        //int max[] = maxMethod(arr, 0, arr.length - 1, arr.length % 2);
        System.out.println(solution(arr, 0, N));
        //System.out.println(Math.max(max[0], max[1]));
    }

    private static int[] maxMethod(int[] arr, int i, int j, int m) {
        int[] result = new int[2];
        if (i > j) {
            return result;
        }
        if (i == j) {
            result[1 - m] = arr[i];
            return result;
        }
        if (i == j - 1) {
            result[m] = Math.max(arr[i], arr[j]);
            result[1-m] = Math.min(arr[i], arr[j]);
            return result;
        }
        if (((j - i) % 2 == 1 - m)) {
            int max = arr[i] + maxMethod(arr, i+1, j, m)[0];
            int s = i + 1;
            int e = j;
            int t = arr[j] + maxMethod(arr, i, j - 1, m)[0];
            if (max < t) {
                max = t;
                s = i;
                e = j - 1;
            }
            result[0] = max;
            result[1] = maxMethod(arr, s, e, m)[1];
        }
        if ((j - i) % 2 == m) {
            int max = arr[i] + maxMethod(arr, i + 1, j, m)[1];
            int s = i+1;
            int e = j;
            int t = arr[j] + maxMethod(arr, i, j-1, m)[1];
            if (max < t) {
                max = t;
                s = i;
                e = j - 1;
            }
            result[1] = max;
            result[0] = maxMethod(arr, s, e, m)[0];
        }
        return result;
    }

    private static int solution(int[] arr, int st, int len) {
        if (st > len) {
            return 0;
        }
        if (st == len) {
            return arr[st];
        }
        int t1 = Math.min(arr[st] - arr[st + 1] + solution(arr,st + 2, len), arr[st] - arr[len] + solution(arr,st + 1, len - 1));
        int t2 = Math.min(arr[len] - arr[len - 1] + solution(arr, st, len - 2), arr[len] - arr[st] + solution(arr,st + 1, len - 1));
        return Math.max(t1, t2);
    }
}
