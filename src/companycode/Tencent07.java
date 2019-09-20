package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-20
 */
public class Tencent07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            String s = in.next();
            if (n < 11) {
                System.out.println("NO");
                return;
            }
            System.out.println(func(s, n) ? "YES" : "NO");
        }
    }

    private static boolean func(String s, int n) {
        int i = 0;
        for (; i < n; i++) {
            if (s.charAt(i) == '8') {
                break;
            }
        }
        if (n - i >= 11) {
            return true;
        } else {
            return false;
        }
    }
}
