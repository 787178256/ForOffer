package companycode;

/**
 * Created by kimvra on 2019-09-11
 */
public class XiaoMi1 {
    public static void main(String[] args) {
        int[] arr = {4,4,5,3,2,1};
        System.out.println(func(arr));
    }

    private static int solution(int[] arr) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count1++;
                } else if (arr[j] > arr[i]) {
                    count2++;
                }
            }
        }
        System.out.println(count1);
        System.out.println(count2);
        return Math.min(count1, count2);
    }

    private static int func(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] >= arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        if (res == 1) {
            res = 0;
        } else {
            res = res > arr.length / 2 ? arr.length - res : res;
        }
        return res;
    }
}
