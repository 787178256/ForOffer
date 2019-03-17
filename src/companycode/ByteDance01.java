package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-16
 */
public class ByteDance01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1024) {
            System.out.println(0);
            return;
        }
        int rest = 1024 - n;
        int max = 64;
        int count = 0;
        while (max > 0) {
            count += rest / max;
            rest = rest % max;
            max = max / 4;
        }
        System.out.println(count);
    }
}
