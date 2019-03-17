package companycode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-16
 */
public class ByteDance02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<String> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(in.next());
        }
        for (String s : list) {
            fun(s);
        }
    }

    private static void fun(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        if (s.length() <= 2) {
            System.out.println(s);
            return;
        }
        int len = s.length();
        char[] dp = new char[len];
        dp[0] = s.charAt(0);
        dp[1] = s.charAt(1);
        for (int i = 2, j = 2; i < len;) {
            if (s.charAt(i) != dp[j - 1]) {
                dp[j++] = s.charAt(i++);
                continue;
            } else if (j - 2 >= 0) { // 相等的情况
                if (dp[j - 2] == dp[j - 1]) {
                    i++;
                } else if (j - 3 >= 0){
                    if (dp[j - 3] == dp[j - 2]) {
                        i++;
                    } else {
                        dp[j++] = s.charAt(i++);
                    }
                } else {
                    dp[j++] = s.charAt(i++);
                }
            }
        }
        System.out.println(new String(dp));
    }
}
