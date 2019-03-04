package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-04
 */
public class HW7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        solution(str1);
        solution(str2);
    }

    private static void solution(String str) {
        int a = str.length() / 8;
        int b = str.length() % 8;
        if (a >= 1) {
            for (int i = 0; i < a; i++) {
                System.out.println(str.substring(i * 8, i * 8 + 8));
            }
            if (b > 0) {
                int c = 8 - b;
                String temp = "";
                while (c > 0) {
                    temp += "0";
                    c--;
                }
                System.out.println(str.substring(8 * a, 8 * a + b) + temp);
            }
        } else if (a < 1) {
            int c = 8 - b;
            String temp = "";
            while (c > 0) {
                temp += "0";
                c--;
            }
            System.out.println(str + temp);
        }
    }
}
