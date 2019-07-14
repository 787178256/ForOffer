package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-07-14
 */
public class Byte2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = func(in.next());
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.print(strings[n - 1]);
    }

    private static String func(String s) {
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            if (i == j) {
                stringBuilder.append(s.charAt(i));
            } else {
                stringBuilder.append(s.charAt(i)).append(s.charAt(j));
            }
        }
        return stringBuilder.toString();
    }
}
