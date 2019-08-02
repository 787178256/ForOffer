package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-01
 */
public class WY05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        System.out.println(max(a, b, c));
    }

    private static int max(int a, int b) {
        return Math.max(a + b, a * b);
    }

    private static int max(int a, int b, int c) {
        return Math.max(max(max(a, b), c), max(a, max(b, c)));
    }
}
