package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-07-14
 */
public class Byte1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int left = in.nextInt();
        int right = in.nextInt();
        if (left >= right - 1) {
            System.out.println("NO");
            return;
        }
        for (int i = left; i < right - 1; i++) {
            for (int j = i + 1; j < right; j++) {
                for (int l = j + 1; l <= right; l++) {
                    if (func(i, j, l)) {
                        System.out.println("YES");
                        System.out.println(i + " " + j + " " + l);
                        return;
                    }
                }
            }
        }
    }

    private static boolean func(int a, int b, int c) {
        if (a + b > c && Math.abs(a - b) < c && a + c > b && Math.abs(a - c) < b && b + c > a && Math.abs(b - c) < a) {
            return true;
        }
        return false;
    }
}
