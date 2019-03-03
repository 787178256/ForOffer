package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-01
 */
public class HW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int len = s.length();
        int res = 0;
        for (int i = 2; i < len; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                res = res * 16 + Integer.parseInt(String.valueOf(s.charAt(i)));
            } else {
                res = res * 16 + (s.charAt(i) - '0' - 7);
            }
        }
        System.out.println(res);
    }
}
