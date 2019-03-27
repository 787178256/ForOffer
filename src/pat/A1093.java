package pat;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-25
 */
public class A1093 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        func(s);
    }

    private static void func(String s) {
        int len = s.length();
        int[] leftNum = new int[len];
        int[] rightNum = new int[len];
        for (int i = 1; i < len; i++) {
            leftNum[i] = s.charAt(i - 1) == 'P' ? leftNum[i - 1] + 1 : leftNum[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            rightNum[i] = s.charAt(i + 1) == 'T' ? rightNum[i + 1] + 1 : rightNum[i + 1];
        }
        int count = 0;
        for (int i = 1; i < len - 1; i++) {
            if (s.charAt(i) == 'A') {
                count += leftNum[i] * rightNum[i];
            }
        }
        System.out.println(count);
    }
}
