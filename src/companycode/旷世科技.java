package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-09
 */
public class 旷世科技 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
